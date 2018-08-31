package com.fpt.drawingapp.service.impl;

import com.fpt.drawingapp.constant.CommandTypeEnum;
import com.fpt.drawingapp.exception.InvalidParameterException;
import com.fpt.drawingapp.exception.QuitProgramException;
import com.fpt.drawingapp.model.*;
import com.fpt.drawingapp.service.CommandService;
import com.fpt.drawingapp.service.DrawServicePopulator;

import java.util.ArrayList;
import java.util.List;

public class CommandServiceImpl implements CommandService {
    private static final CanvasDrawService CANVAS_DRAW_SERVICE = new CanvasDrawService();
    private static final LineDrawService LINE_DRAW_SERVICE = new LineDrawService();
    private static final RectangleDrawService RECTANGLE_DRAW_SERVICE = new RectangleDrawService();
    private static final BucketFillDrawService BUCKET_FILL_SERVICE = new BucketFillDrawService();

    private static final DrawServicePopulator POPULATOR = new DrawServicePopulator();

    @Override
    @SuppressWarnings("unchecked")
    public void handle(final String inputValue, final Canvas canvas) {
        final String parameters[] = inputValue.trim().split("\\s+");

        if (parameters.length == 0) {
            throw new InvalidParameterException("Wrong command request! Try one of the following: \n" +
                    "C w h; \n" +
                    "L x1 y1 x2 y2; \n" +
                    "R x1 y1 x2 y2; \n" +
                    "B x y c or \n" +
                    "Q for quit.\n");
        }

        final CommandTypeEnum commandType = CommandTypeEnum.fromValue(parameters[0]);

        switch (commandType) {
            case C:
                if (parameters.length != 3) {
                    throw new InvalidParameterException("Wrong parameters for creating a new canvas: C w h");
                }

                final List<Integer> params = getInputParams(parameters);
                POPULATOR.populate(CANVAS_DRAW_SERVICE, params, canvas);
                break;
            case L:
                if (parameters.length != 5) {
                    throw new InvalidParameterException("Wrong parameters for creating a line: L x1 y1 x2 y2");
                }

                final Line line = new Line(new Point(Integer.valueOf(parameters[1]), Integer.valueOf(parameters[2])),
                        new Point(Integer.valueOf(parameters[3]), Integer.valueOf(parameters[4])));

                POPULATOR.populate(LINE_DRAW_SERVICE, line, canvas);
                break;
            case R:
                if (parameters.length != 5) {
                    throw new InvalidParameterException("Wrong parameters for creating a new rectangle: R x1 y1 x2 y2");
                }

                final Rectangle rectangle = new Rectangle(new Point(Integer.valueOf(parameters[1]), Integer.valueOf(parameters[2])),
                        new Point(Integer.valueOf(parameters[3]), Integer.valueOf(parameters[4])));

                POPULATOR.populate(RECTANGLE_DRAW_SERVICE, rectangle, canvas);
                break;
            case B:
                if (parameters.length != 4) {
                    throw new InvalidParameterException("Wrong parameters for full filling the area: B x y c");
                }

                final FillPoint fillPoint = new FillPoint(Integer.valueOf(parameters[1]), Integer.valueOf(parameters[2]), parameters[3]);

                POPULATOR.populate(BUCKET_FILL_SERVICE, fillPoint, canvas);
                break;
            case UNKNOWN:
                throw new InvalidParameterException("Invalid command");
            case Q:
                throw new QuitProgramException("Stop application!");
            default:
                break;
        }
    }

    private List<Integer> getInputParams(final String[] parameters) {
        final List<Integer> params = new ArrayList<>();
        for (int i = 1; i < parameters.length; i++) {
            params.add(Integer.valueOf(parameters[i]));
        }

        return params;
    }
}