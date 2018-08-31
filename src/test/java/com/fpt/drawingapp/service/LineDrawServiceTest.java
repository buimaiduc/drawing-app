package com.fpt.drawingapp.service;

import com.fpt.drawingapp.constant.FiledConstant;
import com.fpt.drawingapp.model.Line;
import com.fpt.drawingapp.model.Point;
import com.fpt.drawingapp.service.impl.LineDrawService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LineDrawServiceTest extends DrawServiceTest {

    @Test
    public void testLineDrawService() {
        // Given:
        final LineDrawService lineDrawService = new LineDrawService();
        final Line line = new Line(new Point(1, 1), new Point(1, height));

        // When:
        lineDrawService.draw(line, canvas);

        // Then:
        final String mat[][] = canvas.getPoints();
        int countPoints = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (j == 0) {
                    assert (FiledConstant.HORIZONTAL_CHAR.equals(mat[i][j]));
                }
                // count all the 'x' present in the point.
                if (FiledConstant.LINE_CHAR.equals(mat[i][j])) {
                    countPoints++;
                }
            }
        }
        assertEquals(height, countPoints);
    }
}
