package edu.nyu.cs.codinginterview.chapter09;

import java.util.ArrayList;
import java.util.List;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * You have a stack of n boxes with width wi, height hi, and depth di. The boxes cannot be rotated and can 
 * only be stacked on top of one another if each box in the stack is strictly larger than the box above is 
 * in width, height, and depth. Implement a method to build the tallest stack possible, where the height of 
 * a stack is the sum of the heights of each box.
 */
public class BoxSolution {
    
    private BoxSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(n^3)
     * space complexity O(n^2)
     * @param boxes
     * @return
     */
    public static List<Box> maxHeights(Box[] boxes) {
        Check.nullCheck(boxes, "boxes");
        for (Box box : boxes) {
            Check.nullCheck(box, "box");
        }
        
        int n = boxes.length;
        Index[][] heights = new Index[n][n];
        maxHeightDP(boxes, heights);
        return maximumHeightBoxes(heights);
    }
    
    private static void maxHeightDP(Box[] boxes, Index[][] heights) {
        assert boxes != null;
        assert heights != null;
        
        int n = boxes.length;
        for (int i = 0; i < n; i++) {
            heights[0][i] = new Index(boxes[i].getHeight(), boxes[i]);
        }
        for (int l = 1; l < n; l++) {
            for (int b = 0; b < n; b++) {
                heights[l][b] = new Index();
                for (int i = 0; i < n; i++) {
                    if (i != b && boxes[i].isValidAbove(boxes[b])) {
                        int h = boxes[b].getHeight() + heights[l - 1][i].getHeight();
                        if (h > heights[l][b].getHeight()) {
                            heights[l][b].setHeight(h);
                            heights[l][b].setAbove(boxes[i]);
                        }
                    }
                }
            }
        }
    }
    
    private static List<Box> maximumHeightBoxes(Index[][] a) {
        assert a != null;
        
        Index max = new Index();
        int row = -1;
        int col = -1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j].compareTo(max) > 0) {
                    max = a[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        List<Box> boxes = new ArrayList<Box>();
        Box box = null;
        for (int i = row, j = col; i > 0; i--) {
            box = a[i][j].getAbove();
            boxes.add(a[i][j].getAbove());
            j = box.getId();
        }
        return boxes;
    }

}
