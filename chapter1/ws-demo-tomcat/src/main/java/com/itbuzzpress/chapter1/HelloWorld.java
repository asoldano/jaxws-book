package com.itbuzzpress.chapter1;

 


import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
@WebService
@SOAPBinding(style = Style.RPC)	
public class HelloWorld   {
   @WebMethod
   public String echo(String input) {
      return "Hi " + input;
   }
}


