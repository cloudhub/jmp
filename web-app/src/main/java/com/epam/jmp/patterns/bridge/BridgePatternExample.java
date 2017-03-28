package com.epam.jmp.patterns.bridge;

/**
 * Created by alexei.okhrimenko on 15.03.2017.
 */
public class BridgePatternExample {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
