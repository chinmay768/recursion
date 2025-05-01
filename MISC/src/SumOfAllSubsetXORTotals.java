import java.util.ArrayList;
import java.util.List;

public class SumOfAllSubsetXORTotals {

    public static void generateSubsets(int[] arr, List<List<Integer>> list, int idx, List<Integer> currList){
        if(idx == arr.length){
            list.add(new ArrayList<>(currList));
            return;
        }

        currList.add(arr[idx]);
        generateSubsets(arr, list, idx + 1, currList);
        currList.removeLast();

        generateSubsets(arr, list, idx + 1, currList);
    }

    //TC: O(2^n * L) *
    public static int subsetXORSumNaive(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(nums, subsets, 0, new ArrayList<>());

        int result = 0;

        for(List<Integer> subset : subsets){
            int xor = 0;
            for (Integer num : subset){
                xor ^= num;
            }

            result += xor;
        }

        return result;
    }

    public static int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }

    public static int helper(int[] nums, int idx, int xor) {
        if(idx == nums.length) return xor;

        int include = helper(nums, idx + 1, nums[idx] ^ xor);
        int include = helper(nums, idx + 1, nums[idx] ^ xor);
        int exclude = helper(nums, idx + 1, xor);

        return include + exclude;
    }

    public static void main(String[] args) {
        int[] nums = {5,1,6};
        System.out.println(subsetXORSumNaive(nums));
    }
}
