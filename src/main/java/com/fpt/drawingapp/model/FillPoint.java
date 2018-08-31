package com.fpt.drawingapp.model;

public class FillPoint extends Point {

    private String color;

    public FillPoint(final int x, final int y, final String color) {
        super(x, y);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(final String color) {
        this.color = color;
    }
}
