package com.epam.jmp.patterns.facade;

/**
 * Created by alexei.okhrimenko on 14.03.2017.
 */
public class Home implements Phone {
    public void call() {
        System.out.println("call home");
    }
}
