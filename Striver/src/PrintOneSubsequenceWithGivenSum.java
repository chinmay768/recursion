import java.util.ArrayList;
import java.util.List;

public class PrintOneSubsequenceWithGivenSum {

    public static Boolean printOneSubsequenceWithGivenSum(int[] arr, int idx, int k, List<Integer> res, int sum){
        if(idx >= arr.length){
            if(sum == k){
                System.out.println(res);
                return true;
            }
            return false;
        }

        // incl
        res.add(arr[idx]);
        if(printOneSubsequenceWithGivenSum(arr, idx + 1, k, res, sum + arr[idx])) return true;
        res.removeLast();

        //excl
        if(printOneSubsequenceWithGivenSum(arr, idx + 1, k , res, sum)) return true;

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 7;

        printOneSubsequenceWithGivenSum(arr, 0, k, new ArrayList<>(), 0);
    }
}
