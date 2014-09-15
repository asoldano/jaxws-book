package com.itbuzzpress.chapter3;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlList;

@WebService(targetNamespace = "http://list.binding.ns/",
			name = "SampleEndpoint",
			serviceName = "SampleEndpointService",
			portName = "SampleEndpointPort")
public class SampleEndpoint {

	@WebMethod
	public List<String> process(List<String> list) {
		System.out.println("process: " + list);
		return list;
	}
	
	@WebMethod
	@XmlList
	public List<String> processXmlList(@XmlList List<String> list) {
		System.out.println("processXmlList: " + list);
		return list;
	}
}
