public class SudokuSolver {

    public static boolean solveSudoku(char[][] board) {
//        return solveSudokuHelper(board);
        return solveSudokuHelper2(board, 0, 0);
    }

    public static boolean solveSudokuHelper(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char k = '1'; k <= '9'; k++){
                        if(isSafe(board, i, j, k)){
                            board[i][j] =  k;
                            if(solveSudokuHelper(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solveSudokuHelper2(char[][] board, int row, int col){
        if(row == board.length) return true;

        int nextRow = row;
        int nextCol = col + 1;
        if(nextCol == board[0].length){
            nextRow = row + 1;
            nextCol = 0;
        }

        if(board[row][col] != '.'){
            return solveSudokuHelper2(board, nextRow, nextCol);
        }

        for(char ch = '1'; ch <= '9'; ch++){
            if(isSafe(board, row, col, ch)){
                board[row][col] = ch;
                if(solveSudokuHelper2(board, nextRow, nextCol)) return true;
                board[row][col] = '.';
            }
        }
        return false;
    }

    private static boolean isSafe(char[][] board, int row, int col, char val){
        for(int i = 0; i < 9; i++){
            if(board[row][i] == val) return false;

            if(board[i][col] == val) return false;

            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == val) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + ",");
            }
            System.out.println();
        }
    }
}
