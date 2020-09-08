package ar.edu.unq.desapp.grupod.argconectadabackend.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude={org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class})
@ComponentScan (basePackages = {"ar.edu.unq.desapp.grupod.argconectadabackend.webservices"})
public class ArgconectadaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArgconectadaBackendApplication.class, args);
	}

}
