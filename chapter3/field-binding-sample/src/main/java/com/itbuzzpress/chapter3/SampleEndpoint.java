package com.itbuzzpress.chapter3;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(targetNamespace = "http://field.binding.ns/",
			name = "SampleEndpoint",
			serviceName = "SampleEndpointService",
			portName = "SampleEndpointPort")
public class SampleEndpoint {

	@WebMethod
	public SampleBean echo(SampleBean bean) {
		System.out.println("process: " + bean);
		return bean;
	}
}
