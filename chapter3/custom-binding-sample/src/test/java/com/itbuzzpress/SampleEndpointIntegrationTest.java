package com.itbuzzpress;

import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

import client.SampleEndpoint;
import client.SampleEndpointService;

public class SampleEndpointIntegrationTest {

    @Test
    public void testSampleEndpoint() throws Exception {
    	SampleEndpointService service = new SampleEndpointService(new URL("http://localhost:8080/custom-binding-sample/SampleEndpointService?wsdl"));
    	SampleEndpoint port = service.getSampleEndpointPort();
        Assert.assertEquals("Foo-45", port.process("Foo-45"));
        Assert.assertEquals("Bar-34", port.processCustom("Bar-34"));
    }
}
