public class NQueens {

    static int NQueens(boolean[][] board, int r){
        if(r >= board.length){
            display(board);
            return 1;
        }

        int count = 0;
        for(int col = 0; col < board.length; col++){
            if(isSafe(board, r, col)){
                board[r][col] = true;
                count += NQueens(board, r + 1);
                board[r][col] = false;
            }
        }

        return count;
    }

    static boolean isSafe(boolean[][] board, int row, int col){
        //Vertical Check
        for(int i = row - 1; i >= 0; i--){
            if(board[i][col]){
                return false;
            }
        }

        //Left Diagonal
        int minRowColLeft = Math.min(row, col);
        for(int i = 1; i <= minRowColLeft; i++){
            if(board[row - i][col - i]){
                return false;
            }
        }

        //Right Diagonal
        int minRowColRight = Math.min(row, board.length - 1 - col);
        for(int i = 1; i <= minRowColRight; i++){
            if(board[row - i][col + i]){
                return false;
            }
        }

        return true;
    }

    static void display(boolean[][] board){
        for(int i =0; i < board.length; i++){
            for(int j =0; j < board[0].length; j++){

                if(board[i][j]){
                    System.out.print("Q");
                }else {
                    System.out.print("_");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(NQueens(board, 0));
    }
}
