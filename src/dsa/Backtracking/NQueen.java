package dsa.Backtracking;
import java.util.*;

public class NQueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> board = new ArrayList<>();
        int[] rowCheck = new int[n];
        int[] colCheck = new int[n];
        Set<Integer> diag = new HashSet<>();
        Set<Integer> antiDiag = new HashSet<>();
        List<String> row_list = new ArrayList<>();
        updateBoard(board,n,0,rowCheck,colCheck,diag,antiDiag,row_list);
        return board;
    }

    public void updateBoard(List<List<String>> board, int n, int row,int[] rowCheck, int[] colCheck,Set<Integer> diag,Set<Integer> antiDiag, List<String> row_list){
        if(row == n){
            board.add(new ArrayList<>(row_list));
            return;
        }

        StringBuilder position = new StringBuilder();
        for(int j = 0; j < n; j++) {
            position.append(".");
        }


        for(int col=0;col<n;col++){
            if(validPlace(board,row, col,rowCheck, colCheck,diag,antiDiag)){
                position.setCharAt(col, 'Q');
                row_list.add(position.toString());
                rowCheck[row]=1;
                colCheck[col]=1;
                diag.add(row-col);
                antiDiag.add(row+col);

                updateBoard(board,n, row+1,rowCheck,colCheck,diag,antiDiag,row_list);

                rowCheck[row]=0;
                colCheck[col]=0;
                row_list.remove(position.toString());
                position.setCharAt(col, '.');
                diag.remove(row-col);
                antiDiag.remove(row+col);
            }
        }
        return;
    }
    public boolean validPlace(List<List<String>> board, int row, int col,int[] rowCheck, int[] colCheck,Set<Integer> diag,Set<Integer> antiDiag){
        if(rowCheck[row]==1 || colCheck[col]==1 || diag.contains(row-col) || antiDiag.contains(row+col)){
            return false;
        }
        return true;
    }
}
