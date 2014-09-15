package com.itbuzzpress;

import java.net.URL;
import java.util.Map;

import javax.xml.ws.BindingProvider;

import org.apache.cxf.ws.security.SecurityConstants;
import org.junit.Assert;
import org.junit.Test;

import com.itbuzzpress.chapter5.KeystorePasswordCallback;

import client.HelloWorld;
import client.HelloWorldService;
import client.Person;

public class HelloWorldIntegrationTest {

    @Test
    public void testHelloWorld() throws Exception {
    	HelloWorldService service = new HelloWorldService(new URL("http://localhost:8080/wsse-sign-encrypt-sample/HelloWorldService?wsdl"));
    	HelloWorld port = service.getHelloWorldPort();
    	setupWSSecurity(port);
        Assert.assertEquals("Hello Alice", port.sayHi("Alice"));
        Person p = new Person();
        p.setName("Anne");
        p.setSurname("Li");
        setupWSSecurity(port);
        Assert.assertEquals("Greetings Anne Li", port.greetings(p));
    }
    
    private void setupWSSecurity(HelloWorld port) {
        Map<String, Object> ctx = ((BindingProvider)port).getRequestContext();
    	ctx.put(SecurityConstants.CALLBACK_HANDLER, new KeystorePasswordCallback());
        ctx.put(SecurityConstants.SIGNATURE_PROPERTIES, Thread.currentThread().getContextClassLoader().getResource("alice.properties"));
        ctx.put(SecurityConstants.ENCRYPT_PROPERTIES, Thread.currentThread().getContextClassLoader().getResource("alice.properties"));
        ctx.put(SecurityConstants.SIGNATURE_USERNAME, "alice");
        ctx.put(SecurityConstants.ENCRYPT_USERNAME, "bob");
    	
    }
}
