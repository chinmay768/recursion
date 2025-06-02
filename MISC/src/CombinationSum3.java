import java.util.*;
public class CombinationSum3 {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        solve(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    public static void solve(int k, int n, int i, List<Integer> curr, List<List<Integer>> result) {
        if(n == 0 && k == 0){
            result.add(new ArrayList<>(curr));
            return;
        }

        if(i > 9) return;
        if(n < 0 || k < 0) return;


        curr.add(i);
        solve(k - 1, n - i, i + 1, curr, result);
        curr.removeLast();

        solve(k, n, i + 1, curr, result);
    }

    public static void main(String[] args) {
        int k = 3, n = 7;

        System.out.println(combinationSum3(k, n));
    }
}
