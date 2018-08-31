package com.fpt.drawingapp.model;

import java.util.Objects;

public class Canvas {
    private int width;
    private int height;
    private String[][] points;

    public Canvas(final int width, final int height) {
        this.width = width + 2;
        this.height = height + 2;
        this.points = new String[this.width][this.height];
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(final int width) {
        this.width = width + 2;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(final int height) {
        this.height = height + 2;
    }

    public String[][] getPoints() {
        return points;
    }

    public void setPoints(final String[][] points) {
        this.points = points;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Canvas canvas = (Canvas) o;
        return width == canvas.width && height == canvas.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public String toString() {

        final StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                strBuilder.append(points[j][i] == null ? ' ' : this.points[j][i]);
            }
            strBuilder.append("\n");
        }

        return strBuilder.toString();
    }
}