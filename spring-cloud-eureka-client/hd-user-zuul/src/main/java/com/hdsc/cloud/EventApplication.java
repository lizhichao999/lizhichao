package com.hdsc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EventApplication {

	public static void main(String[] args) {
		ApplicationContext app = SpringApplication.run(EventApplication.class, args);
		
		PersonEvent event = new PersonEvent("PersonEvent");
		event.setName("my Event!");
		app.publishEvent(event);
	}

}
