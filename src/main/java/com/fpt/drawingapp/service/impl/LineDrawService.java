package com.fpt.drawingapp.service.impl;

import com.fpt.drawingapp.constant.FiledConstant;
import com.fpt.drawingapp.exception.InvalidParameterException;
import com.fpt.drawingapp.model.Canvas;
import com.fpt.drawingapp.model.Line;
import com.fpt.drawingapp.service.DrawService;
import com.fpt.drawingapp.util.ResourceGuardian;

public class LineDrawService implements DrawService<Line, Canvas> {

    @Override
    public void validate(final Line line, final Canvas canvas) {
        ResourceGuardian.validateNotNull(line, "Line cannot be null");
        ResourceGuardian.validateNotNull(canvas, "Canvas cannot be null");

        if (line.getStartPoint().getX() <= 0 ||
                line.getStartPoint().getY() <=0 ||
                line.getEndPoint().getX() <=0 ||
                line.getEndPoint().getY() <=0) {
            throw new InvalidParameterException("Input parameters should be in positive numbers");
        }

        if ((line.getStartPoint().getX() != line.getEndPoint().getX()) && (line.getStartPoint().getY() != line.getEndPoint().getY())) {
            throw new InvalidParameterException("Only horizontal or vertical lines are supported");
        }

        if ((line.getStartPoint().getX() > line.getEndPoint().getX()) || (line.getStartPoint().getY() > line.getEndPoint().getY())) {
            throw new InvalidParameterException("Wrong parameters: x1 > x2 or y1 > y2");
        }

        if ((line.getEndPoint().getX() > canvas.getWidth() - 2) || (line.getEndPoint().getY() > canvas.getHeight() - 2)) {
            throw new InvalidParameterException("The point should be in the canvas");
        }
    }

    @Override
    public Canvas draw(final Line line, final Canvas canvas) {
        final String[][] points = canvas.getPoints();

        if (line.getStartPoint().getX() == line.getEndPoint().getX()) {
            for (int i = line.getStartPoint().getY(); i <= line.getEndPoint().getY(); i++) {
                points[line.getStartPoint().getX()][i] = FiledConstant.LINE_CHAR;
            }
        } else if (line.getStartPoint().getY() == line.getEndPoint().getY()) {
            for (int i = line.getStartPoint().getX(); i <= line.getEndPoint().getX(); i++)
                points[i][line.getStartPoint().getY()] = FiledConstant.LINE_CHAR;
        }
        canvas.setPoints(points);

        return canvas;
    }
}
