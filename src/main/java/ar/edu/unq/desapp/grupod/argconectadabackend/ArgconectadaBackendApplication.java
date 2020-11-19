package ar.edu.unq.desapp.grupod.argconectadabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableScheduling
public class ArgconectadaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArgconectadaBackendApplication.class, args);
	}

}
