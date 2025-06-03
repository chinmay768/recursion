public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];


        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                // Try form all grids of matrices
                if(findWord(board, word, i, j, visited, 0)) return true;
            }
        }

        return false;
    }

    public static boolean findWord(char[][] board, String word, int i, int j, boolean[][] visited, int curr){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) return false;

        char ch = word.charAt(curr);

        if(ch == board[i][j]) curr++;
        else return false;

        if(curr == word.length()) return true; // Base Case

        visited[i][j] = true;

        // Top
        if(findWord(board, word, i - 1, j, visited, curr)) return true;

        // Right
        if(findWord(board, word, i, j + 1, visited, curr)) return true;


        // Bottom
        if(findWord(board, word, i + 1, j, visited, curr)) return true;

        // Left
        if(findWord(board, word, i, j - 1, visited, curr)) return true;

        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}};
        String word = "SEE";

        System.out.println(exist(board, word));
    }
}
