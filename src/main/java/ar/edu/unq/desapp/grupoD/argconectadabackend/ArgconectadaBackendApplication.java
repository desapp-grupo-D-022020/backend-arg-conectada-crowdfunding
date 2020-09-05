package ar.edu.unq.desapp.grupoD.argconectadabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude={org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class})
public class ArgconectadaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArgconectadaBackendApplication.class, args);
	}

}
