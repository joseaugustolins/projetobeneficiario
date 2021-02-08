package com.test.projetobeneficiario;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjetobeneficiarioApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(ProjetobeneficiarioApplication.class, args);
	}

	@Bean
	public Queue queue() {
		return new Queue("AporteQueue", true);
	}

}
