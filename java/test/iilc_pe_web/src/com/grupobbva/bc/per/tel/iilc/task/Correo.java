package com.grupobbva.bc.per.tel.iilc.task;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


public class Correo {
		
	public static void main(String[] args) throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator("chavez.mario.c@gmail.com", ""));
		email.setTLS(true);
		email.setFrom("chavez.mario.c@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("orion_only_vip@hotmail.com");
		email.send();
	}
}
