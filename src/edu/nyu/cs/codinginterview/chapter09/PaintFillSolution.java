package edu.nyu.cs.codinginterview.chapter09;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * Implement the "paint fill" function that one might see on many image editing programs. That is, given a 
 * screen (represented by a two-dimensional array of colors), a point, and a new color, fill in the surrounding 
 * area until the color changes from the original color.
 */
public class PaintFillSolution {
    
    private PaintFillSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(4^n)
     * space complexity O(n^2)
     */
    public static boolean paintFill(
            PaintColor[][] color, int x, int y, PaintColor newColor) {
        Check.nullCheck(color, "color matrix");
        for (PaintColor[] rows : color) {
            Check.nullCheck(rows, "color row");
            for (PaintColor c : rows) {
                Check.nullCheck(c, "color");
            }
        }
        Check.nullCheck(newColor, "new color");
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException();
        }
        return paintFill(color, x, y, color[y][x], newColor);
    }
    
    private static boolean paintFill(
            PaintColor[][] color, int x, int y, PaintColor oldColor, PaintColor newColor) {
        if (x < 0 || x >= color[0].length
                || y < 0 || y >= color.length) {
            return false;
        }
        if (color[y][x] == oldColor) {
            color[y][x] = newColor;
            paintFill(color, x - 1, y, oldColor, newColor);
            paintFill(color, x + 1, y, oldColor, newColor);
            paintFill(color, x, y - 1, oldColor, newColor);
            paintFill(color, x, y + 1, oldColor, newColor);
        }
        return true;
    }

}
