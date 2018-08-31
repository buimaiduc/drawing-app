package com.fpt.drawingapp.service.impl;

import com.fpt.drawingapp.constant.FiledConstant;
import com.fpt.drawingapp.exception.InvalidParameterException;
import com.fpt.drawingapp.model.Canvas;
import com.fpt.drawingapp.service.DrawService;
import com.fpt.drawingapp.util.CollectionUtils;

import java.util.List;

public class CanvasDrawService implements DrawService<List<Integer>, Canvas> {

    @Override
    public void validate(final List<Integer> parameters, final Canvas canvas) {
        if (CollectionUtils.isEmpty(parameters)) {
            throw new InvalidParameterException("Missing input parameters");
        }

        if (parameters.size() != 2) {
            throw new InvalidParameterException("Only accept 2 arguments: width & height");
        }

        if (parameters.get(0) <= 0 || parameters.get(1) <= 0) {
            throw new InvalidParameterException("Arguments should be a positive int");
        }
    }

    @Override
    public Canvas draw(final List<Integer> integers, final Canvas canvas) {
        canvas.setWidth(integers.get(0));
        canvas.setHeight(integers.get(1));
        final String[][] points = new String[canvas.getWidth()][canvas.getHeight()];

        for (int i = 0; i < canvas.getHeight(); i++) {
            for (int j = 0; j < canvas.getWidth(); j++) {
                if (i == 0 || i == canvas.getHeight() - 1) {
                    points[j][i] = FiledConstant.HORIZONTAL_CHAR;
                } else if (j == 0 || j == canvas.getWidth() - 1) {
                    points[j][i] = FiledConstant.VERTICAL_CHAR;
                }
            }
        }

        canvas.setPoints(points);

        return canvas;
    }
}
