package com.airbus.alten.cacau;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MySessionListener implements HttpSessionListener {
	
  @Override
  public void sessionCreated(HttpSessionEvent se) {
      System.out.println("-- Http User Session Created --");
      HttpSession session = se.getSession();
      System.out.println("session id: " + session.getId());
      session.setMaxInactiveInterval(10*60);//in seconds
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
      System.out.println("-- Http User Session Destroyed --");
  }
  
}
