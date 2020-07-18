package testscripts;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class HandleEmail {
public static void main(String[] args) throws EmailException {
	System.out.println("Test started..........");
	sentEmail();
	System.out.println("email sent.....");
}

private static void sentEmail() throws EmailException {
	Email email = new SimpleEmail();
	email.setHostName("smtp.gmail.com");
	email.setSmtpPort(465);
	email.setAuthenticator(new DefaultAuthenticator("shreyansh.jain79@gmail.com", "shreyansh@7A"));
	email.setSSLOnConnect(true);
	email.setFrom("shreyansh.jain79@gmail.com");
	email.setSubject("TestMail");
	email.setMsg("This is a test mail ... :-)");
	email.addTo("shreyansh791@yahoo.in");
	email.send();
}
}
