package com.epam.jmp.classloaders;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Aleksei_Okhrimenko on 28.02.2017.
 */
public class ExternalClassLoader {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        URL compiledClass = new URL("file:///D:/projects/idea/jmp/target/classes/com/epam/jmp/classloaders/classes");
        URL[] classUrls = {compiledClass};
        ClassLoader classLoader = new URLClassLoader(classUrls);
        Class externalClass = classLoader.loadClass("com.epam.jmp.classloaders.classes.Print");
        System.out.println("Loaded class: " + externalClass.getName());
    }
}
