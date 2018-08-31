package com.fpt.drawingapp.service.impl;


import com.fpt.drawingapp.constant.FiledConstant;
import com.fpt.drawingapp.exception.InvalidParameterException;
import com.fpt.drawingapp.model.Canvas;
import com.fpt.drawingapp.model.Rectangle;
import com.fpt.drawingapp.service.DrawService;
import com.fpt.drawingapp.util.ResourceGuardian;

public class RectangleDrawService implements DrawService<Rectangle, Canvas> {

    @Override
    public void validate(final Rectangle rectangle, final Canvas canvas) {
        ResourceGuardian.validateNotNull(rectangle, "Rectangle cannot be null");
        ResourceGuardian.validateNotNull(rectangle, "Canvas cannot be null");

        if (rectangle.getUpperLeftPoint().getX() <= 0 ||
                rectangle.getUpperLeftPoint().getY() <=0 ||
                rectangle.getLowerRightPoint().getX() <=0 ||
                rectangle.getLowerRightPoint().getY() <=0) {
            throw new InvalidParameterException("Input parameters should be in positive numbers");
        }

        if ((rectangle.getUpperLeftPoint().getX() > rectangle.getLowerRightPoint().getX()) ||
                (rectangle.getUpperLeftPoint().getY() > rectangle.getLowerRightPoint().getY())) {
            throw new InvalidParameterException("Wrong parameters: x1 > x2 or y1 > y2");
        }

        if ((rectangle.getLowerRightPoint().getX() > canvas.getWidth() - 2) ||
                (rectangle.getLowerRightPoint().getY() > canvas.getHeight() - 2)) {
            throw new InvalidParameterException("The point should be in the canvas");
        }

    }

    @Override
    public Canvas draw(final Rectangle rectangle, final Canvas canvas) {
        final String[][] points = canvas.getPoints();
        for (int i = rectangle.getUpperLeftPoint().getY(); i <= rectangle.getLowerRightPoint().getY(); i++) {
            for (int j = rectangle.getUpperLeftPoint().getX(); j <= rectangle.getLowerRightPoint().getX(); j++) {

                if (i == rectangle.getUpperLeftPoint().getY() || i == rectangle.getLowerRightPoint().getY() ||
                        j == rectangle.getUpperLeftPoint().getX() || j == rectangle.getLowerRightPoint().getX()) {
                    points[j][i] = FiledConstant.LINE_CHAR;
                } else {
                    points[j][i] = FiledConstant.EMPTY_CHAR;

                }
            }
        }
        canvas.setPoints(points);

        return canvas;
    }
}
