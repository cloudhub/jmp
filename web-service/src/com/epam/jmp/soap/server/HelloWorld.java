package com.epam.jmp.soap.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Aleksei_Okhrimenko on 23.03.2017.
 */
@WebService(name = "hello")
public class HelloWorld {

    @WebMethod
    public String say(String name) {
        String result = "Hello world from " + name;
        return result;
    }
}
