package com.itbuzzpress;

import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

import client.SampleBean;
import client.SampleEndpoint;
import client.SampleEndpointService;

public class SampleEndpointIntegrationTest {

    @Test
    public void testSampleEndpoint() throws Exception {
    	SampleEndpointService service = new SampleEndpointService(new URL("http://localhost:8080/field-binding-sample/SampleEndpointService?wsdl"));
    	SampleEndpoint port = service.getSampleEndpointPort();
    	SampleBean bean = new SampleBean();
    	bean.setFirstField("Foo");
    	bean.setSecondField("Bar");
    	SampleBean result = port.echo(bean);
        Assert.assertEquals("Foo", result.getFirstField());
        Assert.assertEquals("Bar", result.getSecondField());
    }
}
