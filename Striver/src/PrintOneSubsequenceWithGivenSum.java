import java.util.ArrayList;
import java.util.List;

public class PrintOneSubsequenceWithGivenSum {

    public static Boolean printAllSubsequenceWithGivenSum(int[] arr, int idx, int k, List<Integer> res, int sum){
        if(idx >= arr.length){
            if(sum == k){
                System.out.println(res);
                return true;
            }
            return false;
        }

        // incl
        res.add(arr[idx]);
        if(printAllSubsequenceWithGivenSum(arr, idx + 1, k, res, sum + arr[idx])) return true;
        res.removeLast();

        //excl
        if(printAllSubsequenceWithGivenSum(arr, idx + 1, k , res, sum)) return true;

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 7;

        printAllSubsequenceWithGivenSum(arr, 0, k, new ArrayList<>(), 0);
    }
}
