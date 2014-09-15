package com.itbuzzpress.chapter5;

public class Person {
	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + "]";
	}
	private String name;
	private String surname;
	
	public Person() {
		
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