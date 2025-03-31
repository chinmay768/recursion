import java.util.*;
import java.util.stream.*;

public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
//        List<String> board = IntStream.range(0, n)
//                .mapToObj(i ->  ".".repeat(n))
//                .toList();

        char[][] board = new char[n][n];
        for(int i = 0; i < board.length; i++){
            Arrays.fill(board[i], '.');
        }

        solve(board, result, 0);

        return result;
    }

    public static void solve(char[][] board, List<List<String>> result, int row){
        if(row == board.length){
            result.add(construct(board));
            return;
        }

        for(int col = 0; col < board[0].length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                solve(board, result, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col){
        // Vertical
        for(int i = 0; i < row; i++){
            if(board[i][col] == 'Q') return false;
        }

        // Horizontal
        for(int i = 0; i < col; i++){
            if(board[row][i] == 'Q') return false;
        }

        // Left Diagonal
        int r = row - 1; int c = col - 1;
        while (r >= 0 && c >= 0){
            if(board[r][c] == 'Q') return false;
            r--;c--;
        }

        // Right Diagonal
        r = row - 1; c = col + 1;
        while (r >= 0 && c <= board[0].length - 1){
            if(board[r][c] == 'Q') return false;
            r--;c++;
        }

        return true;
    }

    private static List<String> construct(char[][] board){
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }


    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
