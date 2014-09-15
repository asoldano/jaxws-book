package com.itbuzzpress.chapter2.wsdemo;

 

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
 
    public void testApp()
    {
    	CustomerService service = new CustomerService();

		Customer port = service.getCustomerPort();

		CustomerRecord record = port.locateCustomer("John", "Li", new USAddress());
		
		System.out.println("Customer record is " +record);
        assertNotNull(record);
    }
}
