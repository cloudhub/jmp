package com.epam.jmp.patterns.bridge;

/**
 * Created by alexei.okhrimenko on 15.03.2017.
 */
public abstract class Shape {
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
