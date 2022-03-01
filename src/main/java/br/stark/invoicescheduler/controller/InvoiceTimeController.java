/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.stark.invoicescheduler.controller;

import br.stark.invoicescheduler.entity.InvoiceTime;
import br.stark.invoicescheduler.repository.InvoiceTimeRepository;
import java.time.OffsetDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lucas
 */
@RestController
public class InvoiceTimeController {

    @Autowired
    private InvoiceTimeRepository repository;

    @PostMapping("/addCurrentTime")
    public @ResponseBody
    String addCurrentTime() {

        InvoiceTime invoiceTime = new InvoiceTime();

        OffsetDateTime now = OffsetDateTime.now();

        var timestamp = String.valueOf(System.currentTimeMillis());

        invoiceTime.setTimestamp(timestamp);
        
        repository.deleteAll();

        repository.save(invoiceTime);
        
        return "Success";
    }

    @GetMapping("/getLastTime")
    public InvoiceTime getAllInvoiceTimes() {
        
        var invoiceTimes = repository.findAll();
        
        var last = invoiceTimes.get(invoiceTimes.size()-1);
        
        return last;
    }

}
