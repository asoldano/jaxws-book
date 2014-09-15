package com.itbuzzpress.chapter3;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@WebService(targetNamespace = "http://custom.binding.ns/",
			name = "SampleEndpoint",
			serviceName = "SampleEndpointService",
			portName = "SampleEndpointPort")
public class SampleEndpoint {

	@WebMethod
	public String process(String s) {
		System.out.println("process: " + s);
		return s;
	}
	
	@WebMethod
	@XmlJavaTypeAdapter(SampleAdapter.class)
	public SampleBean processCustom(@XmlJavaTypeAdapter(SampleAdapter.class) SampleBean bean) {
		System.out.println("processCustom: fistAttribute=" + bean.getFistAttribute() + ", secondAttribute=" + bean.getSecondAttribute());
		return bean;
	}
}
