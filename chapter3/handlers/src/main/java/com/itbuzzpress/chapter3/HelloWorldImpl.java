package com.itbuzzpress.chapter3;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.jws.HandlerChain;

@WebService(endpointInterface = "com.itbuzzpress.chapter3.HelloWorld",
            targetNamespace = "http://hello.world.ns/",
            name = "HelloWorld",
            serviceName = "HelloWorldService",
            portName = "HelloWorldPort")
@HandlerChain(file = "handlers.xml")
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

