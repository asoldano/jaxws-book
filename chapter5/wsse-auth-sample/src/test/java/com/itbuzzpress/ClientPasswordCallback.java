package com.itbuzzpress;

import java.util.HashMap;
import java.util.Map;

import org.jboss.wsf.stack.cxf.extensions.security.PasswordCallbackHandler;

public class ClientPasswordCallback extends PasswordCallbackHandler
{
   public ClientPasswordCallback()
   {
      super(getInitMap());
   }
   
   private static Map<String, String> getInitMap() {
      Map<String, String> passwords = new HashMap<String, String>();
      passwords.put("alice", "password");
      passwords.put("bob", "password");
      passwords.put("kermit", "thefrog");
      return passwords;
   }
}
