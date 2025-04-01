import java.util.*;
public class Permutations2 {

    public static List<List<Integer>> permutations(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length]; // Don't user wrapper class to create array
        permutationsHelper(nums, result, list, visited);

        return result;
    }

    public static void permutationsHelper(int[] nums, List<List<Integer>> result, List<Integer> list, boolean[] visited){
        if(list.size() == nums.length){
            if(!result.contains(list))
                result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if(!visited[i]){
                list.add(nums[i]);
                visited[i] = true;
                permutationsHelper(nums, result, list, visited);
                list.removeLast();
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {

    }
}
