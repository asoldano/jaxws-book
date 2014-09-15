package com.itbuzzpress.chapter1;

 


import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWorld {
   @WebMethod
   public String echo(String input) {
      return "Hi " + input;
   }
}


