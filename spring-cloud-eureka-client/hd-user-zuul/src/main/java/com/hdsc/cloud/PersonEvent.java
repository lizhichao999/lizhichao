package com.hdsc.cloud;

import org.springframework.context.ApplicationEvent;

public class PersonEvent extends ApplicationEvent {

	private static final long serialVersionUID = -3583705062126586079L;
	private String name;
	public PersonEvent(Object source) {
		super(source);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
