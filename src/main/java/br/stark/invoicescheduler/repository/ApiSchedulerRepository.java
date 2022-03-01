/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.stark.invoicescheduler.repository;

import br.stark.invoicescheduler.entity.InvoiceTime;
import java.net.MalformedURLException;

/**
 *
 * @author lucas
 */
public interface ApiSchedulerRepository {
     public InvoiceTime getLastInvoice() throws MalformedURLException;
}
