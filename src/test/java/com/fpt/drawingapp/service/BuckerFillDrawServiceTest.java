package com.fpt.drawingapp.service;

import com.fpt.drawingapp.model.*;
import com.fpt.drawingapp.service.impl.BucketFillDrawService;
import com.fpt.drawingapp.service.impl.LineDrawService;
import com.fpt.drawingapp.service.impl.RectangleDrawService;
import org.junit.Test;

public class BuckerFillDrawServiceTest extends DrawServiceTest {
    public final static String COLOR = "o";

    @Test
    public void testHP_FillArea2LeftUpperStartingPoint() {
        // Given:
        final LineDrawService lineDrawService = new LineDrawService();
        final Line line01 = new Line(new Point(1, 2), new Point(6, 2));
        final Line line02 = new Line(new Point(6, 3), new Point(6, 4));

        lineDrawService.draw(line01, canvas);
        lineDrawService.draw(line02, canvas);

        final RectangleDrawService rectangleDrawService = new RectangleDrawService();
        final Point point01 = new Point(14,1);
        final Point point02 = new Point(18, 3);
        rectangleDrawService.draw(new Rectangle(point01, point02), canvas);

        final FillPoint fillPoint = new FillPoint(9, 1, COLOR);
        final BucketFillDrawService bucketFillDrawService = new BucketFillDrawService();

        // When:
        bucketFillDrawService.draw(fillPoint, canvas);
        assertExpected(canvas, COLOR, 47);
    }
}