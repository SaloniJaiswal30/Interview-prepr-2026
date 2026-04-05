package graph;

import java.util.*;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    board[i][j] = '#';
                    if (dfs(board, word, i, j, 1, row, col))
                        return true;
                    board[i][j] = word.charAt(0);
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int current, int row, int col) {
        if (current == word.length())
            return true;
        int[] xi = {0, 0, -1, 1};
        int[] yi = {-1, 1, 0, 0};
        for (int k = 0; k < 4; k++) {
            int xv = i + xi[k];
            int yv = j + yi[k];
            if (xv >= 0 && xv < row && yv >= 0 && yv < col && word.charAt(current) == board[xv][yv]) {
                char temp = board[xv][yv];
                board[xv][yv] = '#';
                if (dfs(board, word, xv, yv, current + 1, row, col))
                    return true;
                board[xv][yv] = temp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordSearch solution = new WordSearch();
        char[][] board = {{'A', 'B', 'C', 'E'},
                         {'S', 'F', 'C', 'S'},
                         {'A', 'D', 'E', 'E'}};
        System.out.println("Word 'ABCCED' exists: " + solution.exist(board, "ABCCED"));
        System.out.println("Word 'SEE' exists: " + solution.exist(board, "SEE"));
        System.out.println("Word 'ABCB' exists: " + solution.exist(board, "ABCB"));
    }
}

