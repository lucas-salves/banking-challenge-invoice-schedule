/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.stark.invoicescheduler.service;

import br.stark.invoicescheduler.http.StarkApi;
import br.stark.invoicescheduler.interactor.InvoiceInteractor;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.*;
import com.starkbank.*;
import java.util.Date;
import java.util.stream.Collectors;
import lombok.Data;

/**
 *
 * @author lucas
 */
@Data
public class SchedulerService {

    private String lastId = "";

    public Invoice isScheduledTime() throws MalformedURLException {

        var lastItemCreated = hasLastItem();

        if (lastItemCreated != null) {

            String timestamp = hasLastItem().created;

            timestamp = String.valueOf(new DateTime(timestamp).getMillis());
//            timestamp = String.valueOf(new DateTime("2022-03-01T02:59:02.815762+00:00").getMillis());

            Long lastTime = Long.parseLong(timestamp);

            var now = DateTime.now(DateTimeZone.UTC);

            var currentTime = now.getMillis();

            var interval = new Interval(lastTime, currentTime).toDurationMillis();

            // 1h=3600000 / 3h=10800000
            if (interval >= 10800000) {
                lastId = "";
                if (!(lastId.equals(lastItemCreated.id))) {
                    lastId = lastItemCreated.id;
                    System.out.println("*=*=*=*=*=*=*=*=Return schedule *=*=*=*=*=*=*=*=");
                    return lastItemCreated;
                }
            }
        }

        return null;
    }

    public Invoice hasLastItem() throws MalformedURLException {
        try {
            InvoiceInteractor interactor = new InvoiceInteractor(new StarkApi());

            var invoices = interactor.listInvoicesUseCase();

            var createdInvoices = invoices.stream()
                    .filter(invoice -> "created".equals(invoice.status))
                    .distinct()
                    .collect(Collectors.toList());

            Invoice lastInvoice = createdInvoices.get(0);

            return lastInvoice;

        } catch (Exception ex) {
            Logger.getLogger(SchedulerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
