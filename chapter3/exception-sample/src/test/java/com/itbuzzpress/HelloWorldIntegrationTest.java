package com.itbuzzpress;

import java.net.URL;

import javax.xml.ws.soap.SOAPFaultException;

import org.junit.Assert;
import org.junit.Test;

import client.HelloWorld;
import client.HelloWorldService;
import client.Person;
import client.UnknownPersonException_Exception;

public class HelloWorldIntegrationTest {

    @Test
    public void testHelloWorld() throws Exception {
    	HelloWorldService service = new HelloWorldService(new URL("http://localhost:8080/exception-sample/HelloWorldService?wsdl"));
    	HelloWorld port = service.getHelloWorldPort();
        Assert.assertEquals("Hello John", port.sayHi("John"));
        Person p = new Person();
        p.setName("Alice");
        p.setSurname("Li");
        Assert.assertEquals("Greetings Alice Li", port.greetings(p));
        p.setName("Mary");
        try {
        	port.greetings(p);
        	Assert.fail("Exception expected!");
        } catch (UnknownPersonException_Exception e) {
        	Assert.assertEquals("Unknown person 'Mary'", e.getMessage());
        	Assert.assertEquals("Mary", e.getFaultInfo().getName());
        	Assert.assertEquals("Li", e.getFaultInfo().getSurname());
        }
        try {
        	port.greetings(null);
        	Assert.fail("Exception expected!");
        } catch (SOAPFaultException e) {
        	Assert.assertEquals("Person is null!", e.getCause().getMessage());
        }
    }
}
