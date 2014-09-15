package com.itbuzzpress.chapter5;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.apache.cxf.interceptor.InInterceptors;
import org.jboss.ejb3.annotation.SecurityDomain;
import org.jboss.ws.api.annotation.EndpointConfig;
import org.jboss.ws.api.annotation.WebContext;

@Stateless
@WebService(endpointInterface = "com.itbuzzpress.chapter5.HelloWorld",
            targetNamespace = "http://hello.world.ns/",
            name = "HelloWorld",
            serviceName = "HelloWorldService",
            portName = "HelloWorldPort",
            wsdlLocation = "WEB-INF/wsdl/HelloWorldService.wsdl")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
@EndpointConfig(configFile = "WEB-INF/jaxws-endpoint-config.xml", configName = "Custom WS-Security Endpoint")
@SecurityDomain("TestWS")
@WebContext(urlPattern="/HelloWorldService")
//be sure to have dependency on org.apache.cxf module, otherwise Apache CXF annotations are ignored 
@InInterceptors(interceptors = {"org.jboss.wsf.stack.cxf.security.authentication.SubjectCreatingPolicyInterceptor"})
public class HelloWorldImpl implements HelloWorld {

	@RolesAllowed("friend")
    public String sayHi(String text) {
    	System.out.println(text);
        return "Hello " + text;
    }
    
	@RolesAllowed("relative")
    public String greetings(Person person) {
    	System.out.println(person);
        return "Greetings " + person.getName() + " " + person.getSurname();
    }
}

