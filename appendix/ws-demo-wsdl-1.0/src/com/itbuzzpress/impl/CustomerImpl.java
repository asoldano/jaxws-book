package com.itbuzzpress.impl;


import javax.xml.bind.annotation.XmlSeeAlso;
import com.itbuzzpress.*;
import javax.jws.WebService;

@WebService(serviceName = "CustomerService", endpointInterface = "com.itbuzzpress.Customer", targetNamespace = "http://wsdemo.chapter2.itbuzzpress.com/")
public class CustomerImpl implements Customer {
	public CustomerRecord locateCustomer(java.lang.String firstName,
			java.lang.String lastName, USAddress address) {
		CustomerRecord c = new CustomerRecord();
		c.setAddress(new USAddress());
		c.setFirstName(firstName);
		c.setLastName(lastName);
		return c;
	}
}