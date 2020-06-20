package co.grandcircus.VoteAssist.Service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;

@Service
public class EmailService {

	@Autowired
	private SendGrid sendGrid;
	
	public void emailParams(String toEmail, String subject, String contentString) {

		sendEmail(toEmail, subject, contentString);
	}
	

	private void sendEmail(String to, String subject, String content) {
		Email fromEmail = new Email("voteassist.admn@gmail.com");
		Email toEmail = new Email(to);
		Content contentObj = new Content("text/plain", content);
	    Mail mail = new Mail(fromEmail, subject, toEmail, contentObj);

	    Request request = new Request();
	    
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      sendGrid.api(request);
	    } catch (IOException ex) {
	      throw new RuntimeException(ex);
	    }
	}
}
