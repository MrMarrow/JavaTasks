package com.sgu.testTasks.main.package2;

public class Rectangle {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Rectangle() {
    }

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getAreaRectangle() {
        return Math.abs(x2 - x1) * Math.abs(y2 - y1);
    }

    public boolean isSquere() {
        return Math.abs(x2 - x1) == Math.abs(y2 - y1);
    }


    @Override
    public String toString() {
        return "x1: " + x1 + "\n"
                + "y1: " + y1 + "\n"
                + "x2: " + x2 + "\n"
                + "y2: " + y2 + "\n";
    }
}
