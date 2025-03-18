import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequences {

    public static void printSubsequences(int[] arr, int idx, List<Integer> res){
        if(idx >= arr.length) {

            System.out.println(res);
            return;
        }

        //incl
        res.add(arr[idx]);
        printSubsequences(arr, idx + 1, res);
        res.removeLast(); // We need to remove the added elm because we are using the same list throughout the recursion

        // excl
        printSubsequences(arr, idx + 1, res);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        printSubsequences(arr, 0, new ArrayList<>());
    }
}
