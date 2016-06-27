package com.lateral.service;

public interface IEmailService {

	void sendEmail(String from, String to, String message) throws Exception;

}
