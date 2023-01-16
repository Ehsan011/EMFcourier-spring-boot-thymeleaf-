package org.idb.emf.EMFCourier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EmfCourierApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmfCourierApplication.class, args);
	}



}
