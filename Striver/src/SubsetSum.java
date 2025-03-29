import java.util.ArrayList;
import java.util.Collections;

public class SubsetSum {

    //TC: O(2^n + n Log(n) // If we sort the sort the array before calling the recursion
    //TC: 2^N + (2^N)log(2^N) ~= 2^N x N // If we sort the result array
    public static ArrayList<Integer> subsetSum(ArrayList<Integer> arr){
        ArrayList<Integer> result = new ArrayList<>();
        subsetSumHelper(arr, result, 0, 0);
        Collections.sort(result);
        return result;
    }

    public static void subsetSumHelper(ArrayList<Integer> arr, ArrayList<Integer> result, int sum, int idx){
        if(idx == arr.size()){
            result.add(sum);
            return;
        }

        // Not Take
        subsetSumHelper(arr, result, sum, idx + 1);

        // Take
        subsetSumHelper(arr, result, sum + arr.get(idx), idx + 1);
    }

    public static void main(String[] args) {
        //Q: Print sum of all possible subsets in an arrayList.
        // The output should be in sorted order
        // Formula of subsets = 2^n
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);arr.add(2);arr.add(3);

        System.out.println(subsetSum(arr));

    }
}
