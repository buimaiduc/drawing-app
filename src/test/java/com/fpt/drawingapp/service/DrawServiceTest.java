package com.fpt.drawingapp.service;

import com.fpt.drawingapp.constant.FiledConstant;
import com.fpt.drawingapp.model.Canvas;
import com.fpt.drawingapp.service.impl.CanvasDrawService;
import org.junit.Before;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public abstract class DrawServiceTest {
    protected Canvas canvas;
    protected int width = 20;
    protected int height = 4;

    @Before
    public void setUp() {
        final CanvasDrawService canvasDrawService = new CanvasDrawService();
        canvas = new Canvas(width, height);
        canvasDrawService.draw(Arrays.asList(width, height), canvas);
    }

    protected void assertExpected(Canvas canvas, String pixels, int expected) {
        final String mat[][] = canvas.getPoints();
        int found = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                // count all the 'x' (or 'o') present in the matrix.
                if (pixels.equals(mat[i][j])) {
                    found++;
                }
            }
        }

        assertEquals(expected, found);
    }

    protected void assertExpected(Canvas canvas, int expected) {
        assertExpected(canvas, FiledConstant.LINE_CHAR, expected);
    }
}
