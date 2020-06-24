package co.grandcircus.VoteAssist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VoteAssistApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoteAssistApplication.class, args);
	}

}
