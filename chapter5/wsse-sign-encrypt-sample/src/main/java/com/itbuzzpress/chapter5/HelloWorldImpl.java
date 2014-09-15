package com.itbuzzpress.chapter5;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.jboss.ws.api.annotation.EndpointConfig;

@WebService(endpointInterface = "com.itbuzzpress.chapter5.HelloWorld",
            targetNamespace = "http://hello.world.ns/",
            name = "HelloWorld",
            serviceName = "HelloWorldService",
            portName = "HelloWorldPort",
            wsdlLocation = "WEB-INF/wsdl/HelloWorldService.wsdl")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
@EndpointConfig(configFile = "WEB-INF/jaxws-endpoint-config.xml", configName = "Custom WS-Security Endpoint")
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

