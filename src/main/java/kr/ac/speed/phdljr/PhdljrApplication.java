package kr.ac.speed.phdljr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class PhdljrApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhdljrApplication.class, args);
	}

}
