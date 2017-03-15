package com.epam.jmp.patterns.bridge;

/**
 * Created by alexei.okhrimenko on 15.03.2017.
 */
public class GreenCircle implements DrawAPI {
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}
