package graph;

import java.util.*;

public class FloodFillAlgorithm {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int original = image[sr][sc];
        if (original == newColor)
            return image;

        dfs(image, sr, sc, newColor, original);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int newColor, int original) {
        int[][] nearest = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int rowlen = image.length;
        int collen = image[0].length;
        image[sr][sc] = newColor;
        for (int[] near : nearest) {
            int row = sr + near[0];
            int col = sc + near[1];
            if (row >= 0 && col >= 0 && row < rowlen && col < collen
                    && image[row][col] == original) {
                image[row][col] = newColor;
                dfs(image, row, col, newColor, original);
            }
        }
    }

    public static void main(String[] args) {
        FloodFillAlgorithm solution = new FloodFillAlgorithm();
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] result = solution.floodFill(image, 1, 1, 2);
        System.out.println("Flood Fill Result:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}

