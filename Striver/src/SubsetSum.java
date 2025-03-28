import java.util.ArrayList;
import java.util.Collections;

public class SubsetSum {

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
