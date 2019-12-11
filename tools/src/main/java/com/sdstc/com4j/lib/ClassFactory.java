package com.sdstc.com4j.lib  ;

import com4j.*;

/**
 * Defines methods to create COM objects
 */
public abstract class ClassFactory {
  private ClassFactory() {} // instanciation is not allowed


  /**
   * Application Lifecyle Managemen Site Administration Client
   */
  public static com.sdstc.com4j.lib.ISAapi7 createSAapi() {
    return COM4J.createInstance( com.sdstc.com4j.lib.ISAapi7.class, "{61D770B4-2C9C-4BFB-9D39-0AF2033A297C}" );
  }
}
