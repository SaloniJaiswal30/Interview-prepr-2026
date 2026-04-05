package graph;

import java.util.*;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int maxarea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    maxarea = Math.max(maxarea, dsa(grid, i, j, row, col) + 1);
                }
            }
        }
        return maxarea;
    }

    public int dsa(int[][] grid, int i, int j, int row, int col) {
        int[] xi = {0, 0, -1, 1};
        int[] yi = {-1, 1, 0, 0};
        int size = 0;
        grid[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            int xv = i + xi[k];
            int yv = j + yi[k];
            if (xv >= 0 && yv >= 0 && xv < row && yv < col && grid[xv][yv] == 1) {
                size = size + dsa(grid, xv, yv, row, col) + 1;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland solution = new MaxAreaOfIsland();
        int[][] grid = {{1, 1, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 1, 1}};
        System.out.println("Max Area of Island: " + solution.maxAreaOfIsland(grid));
    }
}

