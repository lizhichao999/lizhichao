package com.hdsc.cloud;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PersonEventListener implements ApplicationListener<PersonEvent> {

	@Override
	public void onApplicationEvent(PersonEvent event) {

		System.out.println("receiver event:" + event.getName());
		
	}

}
