package br.com.luisFernando.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.luisFernando.restapi.repository.UserRepository;

@SpringBootApplication
public class RestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}
	
	@Bean
	public UserRepository userRepository() {
		return new UserRepository();
	}
}
