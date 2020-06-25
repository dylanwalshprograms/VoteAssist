package co.grandcircus.VoteAssist.configuration;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sendgrid.SendGrid;

/**
 * This is where we are able to get our SendGrid API key from our hidden folder to utilize SendGrid throughout our application.
 */
@Configuration
public class SendGridConfiguration {
	
	@Value("${sendgrid.key}")
	private String key; 
	
	@Bean
	public SendGrid sendGrid() {
		return new SendGrid(key);
	}
}
