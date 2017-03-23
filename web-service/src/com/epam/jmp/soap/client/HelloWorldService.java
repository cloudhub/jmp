/**
 * HelloWorldService.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.epam.jmp.soap.client;

public interface HelloWorldService extends javax.xml.rpc.Service {
    public java.lang.String gethelloAddress();

    public com.epam.jmp.soap.client.HelloWorld gethello() throws javax.xml.rpc.ServiceException;

    public com.epam.jmp.soap.client.HelloWorld gethello(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
