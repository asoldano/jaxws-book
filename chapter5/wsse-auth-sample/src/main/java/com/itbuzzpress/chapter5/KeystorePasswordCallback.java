package com.itbuzzpress.chapter5;

import java.util.HashMap;
import java.util.Map;

import org.jboss.wsf.stack.cxf.extensions.security.PasswordCallbackHandler;

public class KeystorePasswordCallback extends PasswordCallbackHandler
{
   public KeystorePasswordCallback()
   {
      super(getInitMap());
   }
   
   private static Map<String, String> getInitMap() {
      Map<String, String> passwords = new HashMap<String, String>();
      passwords.put("alice", "password");
      passwords.put("bob", "password");
      return passwords;
   }
}
