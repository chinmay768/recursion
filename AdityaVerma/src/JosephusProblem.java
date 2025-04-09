import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {

    public static int josephusProblem(int n, int k){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(i + 1);
        }
        return helper(n, k, list, 0);
    }

    public static int helper(int n, int k, List<Integer> list, int idx){
        if(list.size() == 1) return list.get(0);
        int killIdx = (idx + k - 1) % list.size();

        list.remove(killIdx);

        int nextIdx = killIdx % list.size(); // Node here we are not adding one bc
        return helper(list.size(), k, list, nextIdx);
    }

    public static void main(String[] args) {
        System.out.println(josephusProblem(5, 3));
    }
}
