package com.fpt.drawingapp.model;

import java.util.Objects;

public class Rectangle {
    private Point upperLeftPoint;
    private Point lowerRightPoint;

    public Rectangle(final Point upperLeftPoint, final Point lowerRightPoint) {
        this.upperLeftPoint = upperLeftPoint;
        this.lowerRightPoint = lowerRightPoint;
    }

    public Point getUpperLeftPoint() {
        return upperLeftPoint;
    }

    public void setUpperLeftPoint(final Point upperLeftPoint) {
        this.upperLeftPoint = upperLeftPoint;
    }

    public Point getLowerRightPoint() {
        return lowerRightPoint;
    }

    public void setLowerRightPoint(final Point lowerRightPoint) {
        this.lowerRightPoint = lowerRightPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Rectangle rectangle = (Rectangle) o;
        return Objects.equals(upperLeftPoint, rectangle.upperLeftPoint) && Objects.equals(lowerRightPoint, rectangle.lowerRightPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(upperLeftPoint, lowerRightPoint);
    }
}