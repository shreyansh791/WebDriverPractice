package testscripts;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
public class SendingHtmlEmail {
	public static void main(String[] args) throws EmailException, MalformedURLException {

	  // Create the email message
	  HtmlEmail email = new HtmlEmail();
	  email.setHostName("mail.myserver.com");
	  email.addTo("jdoe@somewhere.org", "John Doe");
	  email.setFrom("me@apache.org", "Me");
	  email.setSubject("Test email with inline image");
	  
	  // embed the image and get the content id
	  URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
	  String cid = email.embed(url, "Apache logo");
	  
	  // set the html message
	  email.setHtmlMsg("<html>The apache logo - <img src=\"cid:"+cid+"\"></html>");

	  // set the alternative message
	  email.setTextMsg("Your email client does not support HTML messages");

	  // send the email
	  email.send();
}
}
