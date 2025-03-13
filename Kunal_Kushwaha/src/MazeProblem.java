import java.util.ArrayList;

public class MazeProblem {

    static int count(int r, int c){
        if(r == 1 || c == 1){
            return 1;
        }

        int bottom = count(r - 1, c);
        int right = count(r, c- 1);
        return bottom + right;
    }

    static void path(String p, int r, int c){
        if(r == 1 && c == 1){
            System.out.println(p);
            return;
        }

        if(r > 1){
            path(p + "D", r -1, c);
        }

        if(c > 1){
            path(p + "R", r, c - 1);
        }
    }

    static ArrayList<String> pathDia(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if(r > 1){
            list.addAll(pathDia(p + "V", r - 1, c));
        }

        if(r > 1 && c > 1){
            list.addAll(pathDia(p + "D", r- 1, c - 1));
        }

        if(c > 1){
            list.addAll(pathDia(p + "H", r, c - 1));
        }

        return list;
    }

    static void pathRestrictions(String p, boolean[][] maze, int r, int c){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(p);
            return;
        }

        if(!maze[r][c]){
            return;
        }

        if(r < maze.length - 1){
            pathRestrictions(p + "D",  maze, r + 1, c);
        }

        if(c < maze[0].length - 1){
            pathRestrictions(p + "R", maze, r, c + 1);
        }
    }

    static void allPaths(String p, boolean[][] maze, int r, int c){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(p);
            return;
        }

        if(!maze[r][c]){
            return;
        }

        maze[r][c] = false;

      if(r < maze.length - 1){
          allPaths(p + "D", maze, r + 1, c);
      }

        if(c < maze[0].length - 1){
            allPaths(p + "R", maze, r, c + 1);
        }

        if(r > 0){
            allPaths(p + "U", maze, r - 1, c);
        }

        if(c > 0){
            allPaths(p + "L", maze, r, c - 1);
        }

        maze[r][c] = true;
    }

    public static void main(String[] args) {
//        System.out.println(pathDia("", 3, 3));

        boolean[][] board = {
                {true, true, true},
                {true, false, true},
                {true, true, true},
        };

        boolean[][] board2 = {
                {true, true, true},
                {true, true, true},
                {true, true, true},
        };

        allPaths("", board2, 0, 0);
    }
}
