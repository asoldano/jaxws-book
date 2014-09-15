package com.itbuzzpress.chapter3;

import java.net.URL;

import javax.xml.ws.spi.Provider;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class JAXWSProviderTest {

    @Test
    public void test() {
    	Provider p = Provider.provider();
        Logger.getLogger(this.getClass()).warn("Current JAXWS Provider: " + p);
        Assert.assertTrue(p.getClass().getName().startsWith("org.jboss."));
    }
}
