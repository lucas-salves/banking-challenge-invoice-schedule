package br.stark.invoicescheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InvoiceSchedulerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(InvoiceSchedulerApplication.class, args);
                
                InvoiceScheduler.main(null);
	}

}
