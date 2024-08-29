package com.projects.videocall;

import com.projects.videocall.user.User;
import com.projects.videocall.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideocallApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideocallApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			UserService userService
	) {
		return args -> {
			userService.register(User.builder()
					.username("Victor")
					.email("victor@email.com")
					.password("senha123")
					.build());

			userService.register(User.builder()
					.username("John")
					.email("john@email.com")
					.password("senha123")
					.build());

			userService.register(User.builder()
					.username("Anny")
					.email("anny@email.com")
					.password("senha123")
					.build());
		};
	}
}
