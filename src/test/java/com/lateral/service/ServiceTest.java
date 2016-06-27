package com.lateral.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class ServiceTest {

	@Test
	public void processInvoice_AmountGreatThan100_ReturnsTrue() throws Exception {
		Invoice invoice = new Invoice("1", "1", new BigDecimal(101));
		MockEmailService emailService = new MockEmailService();
		Service service = new Service(emailService);

		boolean res = service.processInvoice(invoice);

		assertEquals(true, res);
	}

	/**
	 * Mock example - checks if email service is called
	 */
	@Test
	public void processInvoice_AmountGreatThan100_SendsEmail() {
		Invoice invoice = new Invoice("1", "123", new BigDecimal(101));
		MockEmailService emailService = new MockEmailService();
		Service service = new Service(emailService);

		service.processInvoice(invoice);

		assertEquals(true, emailService.called);

		assertEquals("kukic.milorad@gmail.com", emailService.from);
		assertEquals("nikola.kudus@gmail.com", emailService.to);
		assertEquals("Invoice is greater that 100", emailService.message);
	}

	/**
	 * Stub example - use Fake object to control path, not to assert (assert is
	 * on method result).
	 * 
	 * @throws Exception
	 */
	@Test
	public void processInvoice_EmailServiceThrowsException_ReturnsFalse() throws Exception {
		Invoice invoice = new Invoice("1", "1", new BigDecimal(101));
		IEmailService emailService = new EmailServiceThrowsException();
		Service service = new Service(emailService);

		boolean res = service.processInvoice(invoice);

		assertEquals(false, res);
	}

	// ****************
	// *
	// * FAKES
	// *
	// ****************

	public class MockEmailService implements IEmailService {
		public boolean called = false;
		public String from;
		public String to;
		public String message;

		public void sendEmail(String from, String to, String message) throws Exception {
			called = true;
			this.from = from;
			this.to = to;
			this.message = message;
		}
	}

	public class EmailServiceThrowsException implements IEmailService {

		public void sendEmail(String from, String to, String message) throws Exception {
			throw new Exception("No connection");
		}

	}
}
