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

/**
 * In this service we have methods to build the correct email the volunteer would like to send.
 */
@Service
public class EmailService {

	private static final String VOTEASSIST_ADMN = "voteassist.admn@gmail.com";
	
	@Autowired
	private SendGrid sendGrid;
	
	public void sendMessageToAdmin(String returnAddress, String message) {
		StringBuilder bodyBuilder = new StringBuilder();
		bodyBuilder.append("Volunteer return email: ");
		bodyBuilder.append(returnAddress);
		bodyBuilder.append("\n\n");
		bodyBuilder.append(message);
		
		sendEmail(VOTEASSIST_ADMN, VOTEASSIST_ADMN, "Volunteer Request", bodyBuilder.toString());
	}

	public void sendMessageToVoter(String toEmail, String subject, String contentString) {
		sendEmail(toEmail, VOTEASSIST_ADMN, subject, contentString);
	}
	
	public void messageToResetForgottonPasswords(String toEmail, int randomNumber) {
		StringBuilder bodyBuilder = new StringBuilder();
		bodyBuilder.append("Your code is : ");
		bodyBuilder.append(randomNumber);
		bodyBuilder.append("\n\n");
		bodyBuilder.append("Please enter your code in order to reset your password.");
		sendEmail(toEmail, VOTEASSIST_ADMN, "Password Reset", bodyBuilder.toString());
	}
	
	private void sendEmail(String to, String from, String subject, String content) {
		Email fromEmail = new Email(from);
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
