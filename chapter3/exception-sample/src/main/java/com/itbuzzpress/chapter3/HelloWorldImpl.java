package com.itbuzzpress.chapter3;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService(endpointInterface = "com.itbuzzpress.chapter3.HelloWorld",
            targetNamespace = "http://hello.world.ns/",
            name = "HelloWorld",
            serviceName = "HelloWorldService",
            portName = "HelloWorldPort")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
    	System.out.println(text);
        return "Hello " + text;
    }
    
    public String greetings(Person person) throws UnknownPersonException {
    	System.out.println(person);
    	if (person == null) {
			throw new IllegalArgumentException("Person is null!");
    	}
    	if (!person.getName().equals("John") && !person.getName().equals("Alice")) {
    		throw new UnknownPersonException(person);
    	}
        return "Greetings " + person.getName() + " " + person.getSurname();
    }
}

