/**
 * HelloWorldServiceLocator.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.epam.jmp.soap.client;

public class HelloWorldServiceLocator extends org.apache.axis.client.Service implements com.epam.jmp.soap.client.HelloWorldService {

    public HelloWorldServiceLocator() {
    }


    public HelloWorldServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HelloWorldServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for hello
    private java.lang.String hello_address = "http://localhost:8080//services/hello";

    public java.lang.String gethelloAddress() {
        return hello_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String helloWSDDServiceName = "hello";

    public java.lang.String gethelloWSDDServiceName() {
        return helloWSDDServiceName;
    }

    public void sethelloWSDDServiceName(java.lang.String name) {
        helloWSDDServiceName = name;
    }

    public com.epam.jmp.soap.client.HelloWorld gethello() throws javax.xml.rpc.ServiceException {
        java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(hello_address);
        } catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return gethello(endpoint);
    }

    public com.epam.jmp.soap.client.HelloWorld gethello(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.epam.jmp.soap.client.HelloSoapBindingStub _stub = new com.epam.jmp.soap.client.HelloSoapBindingStub(portAddress, this);
            _stub.setPortName(gethelloWSDDServiceName());
            return _stub;
        } catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void sethelloEndpointAddress(java.lang.String address) {
        hello_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.epam.jmp.soap.client.HelloWorld.class.isAssignableFrom(serviceEndpointInterface)) {
                com.epam.jmp.soap.client.HelloSoapBindingStub _stub = new com.epam.jmp.soap.client.HelloSoapBindingStub(new java.net.URL(hello_address), this);
                _stub.setPortName(gethelloWSDDServiceName());
                return _stub;
            }
        } catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("hello".equals(inputPortName)) {
            return gethello();
        } else {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://server.soap.jmp.epam.com", "HelloWorldService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://server.soap.jmp.epam.com", "hello"));
        }
        return ports.iterator();
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {

        if ("hello".equals(portName)) {
            sethelloEndpointAddress(address);
        } else { // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
