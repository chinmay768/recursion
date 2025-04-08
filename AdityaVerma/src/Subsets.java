import java.util.*;
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        subsetSumHelper(nums, result, list, 0);
        // Collections.sort(result);
        return result;
    }

    public static void subsetSumHelper(int[] arr, List<List<Integer>> result, ArrayList<Integer> list, int idx){
        if(idx == arr.length){
            result.add(new ArrayList<>(list));
            return;
        }

        // Not Take
        subsetSumHelper(arr, result, list, idx + 1);

        // Take
        list.add(arr[idx]);
        subsetSumHelper(arr, result, list, idx + 1);
        list.removeLast();
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 9, 4};
        System.out.println(subsets(arr));
    }

}
