import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequencesWithGivenSum {

    public static void printAllSubsequenceWithGivenSum(int[] arr, int idx, int k, List<Integer> res, int sum){
        if(idx >= arr.length){
            if(sum == k){
                System.out.println(res);
            }
            return;
        }

        // incl
        res.add(arr[idx]);
        printAllSubsequenceWithGivenSum(arr, idx + 1, k, res, sum + arr[idx]);
        res.removeLast();

        //excl
        printAllSubsequenceWithGivenSum(arr, idx + 1, k , res, sum);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 7;

        printAllSubsequenceWithGivenSum(arr, 0, k, new ArrayList<>(), 0);
    }
}
