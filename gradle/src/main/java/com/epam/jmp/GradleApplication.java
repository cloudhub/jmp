package com.epam.jmp;

import org.apache.log4j.Logger;

/**
 * Created by Aleksei_Okhrimenko on 22.04.2017.
 */
public class GradleApplication {

    public static final Logger LOGGER = Logger.getLogger(GradleApplication.class);

    public static void main(String[] args) {
        LOGGER.info("started");
        System.out.println(new GradleApplication().printMessage());
        LOGGER.info("finished");
    }

    public String printMessage() {
        return "Hello world!";
    }
}
