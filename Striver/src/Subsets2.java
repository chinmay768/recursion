import java.util.*;

public class Subsets2 {

    //TC: O(2^n * n) // n because each time we are cloning a list and adding it to result
    //SC: O(2^n * k) // Where k is avg size of  list
    public static List<List<Integer>> subsetsWithoutDup(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithoutDupHelper(nums, result,  list, 0);
        return result;
    }

    public static void subsetsWithoutDupHelper(int[] nums, List<List<Integer>> result, List<Integer> list, int idx){
        result.add(new ArrayList<>(list));

        for(int i = idx; i < nums.length; i++){
            if(i > idx && nums[i - 1] == nums[i]) continue; // Skip the repeating elm
            list.add(nums[i]);
            subsetsWithoutDupHelper(nums,  result, list, i + 1);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2};

        System.out.println(subsetsWithoutDup(arr));
    }
}
