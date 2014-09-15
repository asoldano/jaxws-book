package com.itbuzzpress.chapter3;

public class UnknownPersonException extends Exception {

	private static final long serialVersionUID = -6180965086058486260L;
	
	private String name;
	private String surname;

	public UnknownPersonException() {
		super();
	}
	
	public UnknownPersonException(String message) {
		super(message);
	}
	
	public UnknownPersonException(Person person) {
		super("Unknown person '" + person.getName() + "'");
		this.name = person.getName();
		this.surname = person.getSurname();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}
