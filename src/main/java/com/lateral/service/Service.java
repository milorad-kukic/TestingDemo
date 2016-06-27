package com.lateral.service;

import java.math.BigDecimal;

public class Service {

	private IEmailService emailService;

	public Service(IEmailService emailService) {
		this.emailService = emailService;
	}
	
	public boolean processInvoice(Invoice invoice) {
		if (invoice.getAmount().compareTo(new BigDecimal(100)) == 1) {
			try {
				emailService.sendEmail("kukic.milorad@gmail.com", "nikola.kudus@gmail.com",
						"Invoice is greater that 100");
			} catch (Exception e) {
				return false;
			}
		}

		return true;
	}

}
