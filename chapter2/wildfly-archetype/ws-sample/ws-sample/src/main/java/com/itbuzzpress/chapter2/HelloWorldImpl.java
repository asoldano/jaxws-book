package com.itbuzzpress.chapter2;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService(endpointInterface = "com.itbuzzpress.chapter2.HelloWorld",
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
    
    public String greetings(Person person) {
    	System.out.println(person);
        return "Greetings " + person.getName() + " " + person.getSurname();
    }
}

