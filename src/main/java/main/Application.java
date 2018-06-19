package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import dbManagement.model.Agent;
import dbManagement.repository.AgentRepository;

import java.text.ParseException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
@EnableJpaRepositories("dbManagement.repository")
@EntityScan(basePackages = {"dbManagement.model"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner initDB(AgentRepository repository) throws ParseException {

		return (args) -> {
			
			repository.save(new Agent("Pedro Suárez", "", "pedro@gmail.com", "09847581T", "Person", "123456789"));

			repository.save(new Agent("Pepe Fernández", "25.7751&-80.2105", "pepe@gmail.com", "87654321B", "Person", "1234"));
			
			repository.save(new Agent("Sensor Iluminacion SI1", "43.36&-5.85", "carmen@yahoo.com", "SI1Oviedo", "Sensor", "9874"));
			
			repository.save(new Agent("Uniovi", "", "uniovi@example.com", "Q3318001I", "Entity", "147852369"));
		};
	}
}