package co.grandcircus.VoteAssist.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sendgrid.SendGrid;

@Configuration
public class SendGridConfiguration {
	
	@Value("${sendgrid.key}")
	private String key; 
	
	@Bean
	public SendGrid sendGrid() {
		return new SendGrid(key);
	}

}
