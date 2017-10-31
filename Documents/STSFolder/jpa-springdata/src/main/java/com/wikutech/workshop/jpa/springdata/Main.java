package com.wikutech.workshop.jpa.springdata;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.wikutech.workshop")
public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
		
		Application application = context.getBean(Application.class);
		application.runApplication();
	}
}
