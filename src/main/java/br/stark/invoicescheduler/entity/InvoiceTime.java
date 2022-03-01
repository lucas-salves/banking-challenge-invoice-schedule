/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.stark.invoicescheduler.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author lucas
 */
@Data
@Entity // This tells Hibernate to make a table out of this class
public class InvoiceTime {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;

  private String timestamp;


}
