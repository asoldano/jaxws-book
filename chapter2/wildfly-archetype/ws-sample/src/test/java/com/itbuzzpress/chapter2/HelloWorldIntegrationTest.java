package com.itbuzzpress.chapter2;

import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

import client.HelloWorld;
import client.HelloWorldService;
import client.Person;

public class HelloWorldIntegrationTest {

    @Test
    public void testHelloWorld() throws Exception {
    	HelloWorldService service = new HelloWorldService(new URL("http://localhost:8080/ws-sample/HelloWorldService?wsdl"));
    	HelloWorld port = service.getHelloWorldPort();
        Assert.assertEquals("Hello John", port.sayHi("John"));
        Person p = new Person();
        p.setName("Anne");
        p.setSurname("Li");
        Assert.assertEquals("Greetings Anne Li", port.greetings(p));
    }
}
