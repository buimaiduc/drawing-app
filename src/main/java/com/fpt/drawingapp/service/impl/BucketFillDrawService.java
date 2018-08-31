package com.fpt.drawingapp.service.impl;

import com.fpt.drawingapp.constant.FiledConstant;
import com.fpt.drawingapp.exception.InvalidParameterException;
import com.fpt.drawingapp.model.Canvas;
import com.fpt.drawingapp.model.FillPoint;
import com.fpt.drawingapp.model.Point;
import com.fpt.drawingapp.service.DrawService;
import com.fpt.drawingapp.util.CollectionUtils;
import com.fpt.drawingapp.util.StringUtils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BucketFillDrawService implements DrawService<FillPoint, Canvas> {
    @Override
    public void validate(final FillPoint fillPoint, final Canvas canvas) {
        if (fillPoint.getX() <= 0 ||
                fillPoint.getY() <=0) {
            throw new InvalidParameterException("Input parameters should be in positive numbers");
        }

        if ((fillPoint.getX() > canvas.getWidth() - 2) || (fillPoint.getY() > canvas.getHeight() - 2)) {
            throw new InvalidParameterException("The point should be in the canvas");
        }

        if (!StringUtils.isNotEmpty(fillPoint.getColor()) || fillPoint.getColor().length() > 1) {
            throw new InvalidParameterException("The colour should be a char");
        }
    }

    @Override
    public Canvas draw(final FillPoint fillPoint, final Canvas canvas) {
        fillSinglePixelAndExpand(fillPoint.getX(), fillPoint.getY(), fillPoint.getColor(), canvas);

        return canvas;
    }

    private void fillSinglePixelAndExpand(final int x, final int y, final String color, final Canvas canvas) {

        final String[][] canvasPoints = canvas.getPoints();
        final List<Point> points = new LinkedList<>();
        final Set<Point> traversedPoints = new HashSet<>();
        points.add(new Point(x, y));

        while (CollectionUtils.isNotEmpty(points)) {

            final Point currentPoint = points.get(points.size() - 1);
            points.remove(currentPoint);

            if (currentPoint.getX() < 0 || currentPoint.getY() < 0 ||
                    !traversedPoints.add(currentPoint) ||
                    FiledConstant.LINE_CHAR.equals(canvasPoints[currentPoint.getX()][currentPoint.getY()]) ||
                    FiledConstant.HORIZONTAL_CHAR.equals(canvasPoints[currentPoint.getX()][currentPoint.getY()]) ||
                    FiledConstant.VERTICAL_CHAR.equals(canvasPoints[currentPoint.getX()][currentPoint.getY()])) {
                continue;
            }

            canvasPoints[currentPoint.getX()][currentPoint.getY()] = color;
            points.add(new Point(currentPoint.getX() - 1, currentPoint.getY()));
            points.add(new Point(currentPoint.getX() + 1, currentPoint.getY()));
            points.add(new Point(currentPoint.getX(), currentPoint.getY() - 1));
            points.add(new Point(currentPoint.getX(), currentPoint.getY() + 1));
        }
    }
}