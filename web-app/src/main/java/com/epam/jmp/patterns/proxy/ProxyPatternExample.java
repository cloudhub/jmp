package com.epam.jmp.patterns.proxy;

/**
 * Created by alexei.okhrimenko on 15.03.2017.
 */
public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        //image will be loaded from disk
        image.display();
        System.out.println("");

        //image will not be loaded from disk
        image.display();
    }
}
