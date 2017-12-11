package com.hdsc.cloud;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class PersonEventPublisher implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher applicationEventPublisher;

	@Override
	public void setApplicationEventPublisher(
			ApplicationEventPublisher applicationEventPublisher) {

		this.applicationEventPublisher = applicationEventPublisher;

	}
	
	public void publishPersonEvent(PersonEvent event){
		applicationEventPublisher.publishEvent(event);
	}

}
