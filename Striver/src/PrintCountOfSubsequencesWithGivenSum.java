import java.util.ArrayList;
import java.util.List;

public class PrintCountOfSubsequencesWithGivenSum {

    public static int countSubsequenceWithGivenSum(int[] arr, int idx, int k, List<Integer> res, int sum){
        if(idx >= arr.length){
            if(sum == k){
//                System.out.println(res);
                return 1;
            }
            return 0;
        }

        // incl
        res.add(arr[idx]);
        int incl = countSubsequenceWithGivenSum(arr, idx + 1, k, res, sum + arr[idx]);
        res.removeLast();

        //excl
        int excl =countSubsequenceWithGivenSum(arr, idx + 1, k , res, sum);

        return incl + excl;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 7;

        System.out.println(countSubsequenceWithGivenSum(arr, 0, k, new ArrayList<>(), 0));
    }
}
