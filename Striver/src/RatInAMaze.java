import java.util.*;

public class RatInAMaze {

    public static List<String> findPath(List<List<Integer>> matrix){
        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.size()][matrix.size()];

        for(int i = 0; i < visited.length; i++){
            Arrays.fill(visited[i], false);
        }

        helper(matrix, "", result, 0, 0, visited);

        return result;
    }

    public static void helper(List<List<Integer>> matrix, String path, List<String> result, int row, int col, boolean[][] visited){
        if(row < 0 || col < 0 || row > matrix.getFirst().size() - 1 || col > matrix.size() - 1 || visited[row][col] || matrix.get(row).get(col) == 0){
            return;
        }

        if(row == matrix.size() - 1 && col == matrix.getFirst().size() - 1){
            result.add(new String(path));
            return;
        }

        visited[row][col] = true;
        helper(matrix, path + "D", result, row + 1, col, visited);
        helper(matrix, path + "U", result, row - 1, col, visited);
        helper(matrix, path + "L", result, row, col - 1, visited);
        helper(matrix, path + "R", result, row, col + 1, visited);
        visited[row][col] = false;
    }

    public static void main(String[] args) {
//        int[][] matrix= {{1, 0, 0, 0},
//            {1, 1, 0, 1},
//            {1, 1, 0, 0},
//            {0, 1, 1, 1}};
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(1, 0, 0, 0));
        matrix.add(Arrays.asList(1, 1, 0, 1));
        matrix.add(Arrays.asList(1, 1, 0, 0));
        matrix.add(Arrays.asList(0, 1, 1, 1));

        System.out.println(findPath(matrix));
    }
}
