package com.epam.jmp.soap.client;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

/**
 * Created by Aleksei_Okhrimenko on 23.03.2017.
 */
public class HelloWorldClient {
    public static void main(String[] args) {
        HelloWorldServiceLocator serviceLocator = new HelloWorldServiceLocator();
        HelloWorld helloWorld = null;
        try {
            helloWorld = serviceLocator.gethello();
            String string = helloWorld.say("Java mentees");
            System.out.println(string);
        } catch (ServiceException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
