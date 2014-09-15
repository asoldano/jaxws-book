package com.itbuzzpress.chapter3; 

import javax.xml.bind.annotation.XmlAttribute; 

public class SampleBean { 
	private String firstField; 
	private String secondField; 
	 
	@XmlAttribute 
	public String getFirstField() { 
		return firstField; 
	} 
	public void setFirstField(String firstField) { 
		this.firstField = firstField; 
	} 
	public String getSecondField() { 
		return secondField; 
	} 
	public void setSecondField(String secondField) { 
		this.secondField = secondField; 
	} 
}
