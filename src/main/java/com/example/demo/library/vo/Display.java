package com.example.demo.library.vo;

public class Display {

    private final int x;
    private final int y;

    public Display(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Display{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}
