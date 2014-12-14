package edu.nyu.cs.codinginterview.chapter09;

/**
 * @author shenli
 * <p>
 * Imagine a robot sitting on the upper left corner of an X by Y grid. The robot can only move in two directions: 
 * right and down. How many possible paths are there for the robot to go from (0,0) to (X,Y)?
 * <p>
 * FOLLOW UP
 * Imagine certain spots are "off limits", such that the robot cannot step on them. Design an algorithm to find 
 * a path for the robot from the top left to the bottom right.
 */
public class RobotPathSolution {
    
    private RobotPathSolution() {
        throw new AssertionError();
    }
    
    public static long numberOfPaths(int x, int y) {
        if (x < 0 || y < 0) {
            return 0;
        }
        if (x == 0 && y == 0) {
            return 0;
        } else if (x == 0 || y == 0) {
            return 1;
        }
        return numberOfPaths(x - 1, y) + numberOfPaths(x, y - 1);
    }
    
    public static long numberOfPathsBottomUp(int x, int y) {
        if (x < 0 || y < 0) {
            return 0;
        }
        long[][] path = new long[x + 1][y + 1];
        path[0][0] = 0;
        for (int i = 1; i < x + 1; i++) {
            path[i][0] = 1;
        }
        for (int j = 1; j < y + 1; j++) {
            path[0][j] = 1;
        }
        for (int i = 1; i < x + 1; i++) {
            for (int j = 1; j < y + 1; j++) {
                path[i][j] = path[i - 1][j] + path[i][j - 1];
            }
        }
        return path[x][y];
    }
    
    public static long numberOfPathsTopDown(int x, int y) {
        if (x < 0 || y < 0) {
            return 0;
        }
        long[][] path = new long[x + 1][y + 1];
        return numberOfPathsTopDownHelper(x, y, path);
    }
    
    private static long numberOfPathsTopDownHelper(int i, int j, long[][] path) {
        if (i == 0 && j == 0) {
            return 0;
        } else if (i == 0 || j == 0) {
            return 1;
        } else if (path[i][j] > 0) {
            return path[i][j];
        }
        path[i][j] = numberOfPathsTopDownHelper(i - 1, j, path)
                + numberOfPathsTopDownHelper(i, j - 1, path);
        return path[i][j];
    }

}
