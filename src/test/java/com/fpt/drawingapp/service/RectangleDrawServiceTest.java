package com.fpt.drawingapp.service;

import com.fpt.drawingapp.model.Point;
import com.fpt.drawingapp.model.Rectangle;
import com.fpt.drawingapp.service.impl.RectangleDrawService;
import org.junit.Test;

public class RectangleDrawServiceTest extends DrawServiceTest {

    @Test
    public void testRectangleDrawServiceCommonCase() {
        // Given:
        int x1 = 1, y1 = 1, x2 = width, y2 = height;
        final RectangleDrawService rectangleDrawService = new RectangleDrawService();
        final Point point1 = new Point(x1, y1);
        final Point point2 = new Point(x2, y2);

        // When:
        rectangleDrawService.draw(new Rectangle(point1, point2), canvas);

        // Then:
        int expected = (x2 - x1) * 2 + (y2 - y1) * 2;
        assertExpected(canvas, expected);
    }

    @Test
    public void testX1EqualX2() {
        // Given:
        int x1 = 3, y1 = 1, x2 = 3, y2 = 4;
        final RectangleDrawService rectangleDrawService = new RectangleDrawService();
        final Point point1 = new Point(x1, y1);
        final Point point2 = new Point(x2, y2);

        // When:
        rectangleDrawService.draw(new Rectangle(point1, point2), canvas);

        int expected = (y2 - y1) + 1;
        assertExpected(canvas, expected);
    }

    @Test
    public void testY1EqualY2() {
        // Given:
        int x1 = 1, y1 = 1, x2 = 14, y2 = 1;
        final RectangleDrawService rectangleDrawService = new RectangleDrawService();
        final Point point1 = new Point(x1, y1);
        final Point point2 = new Point(x2, y2);

        // When:
        rectangleDrawService.draw(new Rectangle(point1, point2), canvas);

        // Then:
        int expected = (x2 - x1) + 1;
        assertExpected(canvas, expected);
    }
}
