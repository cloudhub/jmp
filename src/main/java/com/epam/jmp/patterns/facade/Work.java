package com.epam.jmp.patterns.facade;

/**
 * Created by alexei.okhrimenko on 14.03.2017.
 */
public class Work implements Phone {
    public void call() {
        System.out.println("call work");
    }
}
