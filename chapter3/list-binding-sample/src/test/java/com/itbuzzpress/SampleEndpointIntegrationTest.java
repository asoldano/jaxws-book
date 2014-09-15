package com.itbuzzpress;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import client.SampleEndpoint;
import client.SampleEndpointService;

public class SampleEndpointIntegrationTest {

    @Test
    public void testSampleEndpoint() throws Exception {
    	SampleEndpointService service = new SampleEndpointService(new URL("http://localhost:8080/list-binding-sample/SampleEndpointService?wsdl"));
    	SampleEndpoint port = service.getSampleEndpointPort();
    	
    	List<String> list = new LinkedList<String>();
    	list.add("Foo");
    	list.add("Bar");
    	
    	List<String> processResult = port.process(list);
        Assert.assertEquals(2, processResult.size());
        Assert.assertTrue(processResult.contains("Foo"));
        Assert.assertTrue(processResult.contains("Bar"));
        
    	List<String> processXmlListResult = port.processXmlList(list);
        Assert.assertEquals(2, processXmlListResult.size());
        Assert.assertTrue(processXmlListResult.contains("Foo"));
        Assert.assertTrue(processXmlListResult.contains("Bar"));
    }
}
