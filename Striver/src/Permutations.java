import java.util.*;
import java.util.stream.Collectors;

public class Permutations {

    public static List<List<Integer>> permutations(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length]; // Don't user wrapper class to create array
        permutationsHelper(nums, result, list, visited);

        return result;
    }

    public static void permutationsHelper(int[] nums, List<List<Integer>> result, List<Integer> list, boolean[] visited){
       if(list.size() == nums.length){
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

    public static List<List<Integer>> permutations2(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        permutations2Helper(nums, result, 0);
        return result;
    }

    public static void permutations2Helper(int[] nums, List<List<Integer>> result, int idx){
        if(idx == nums.length){
            List<Integer> list = Arrays.stream(nums)
                    .boxed()
                    .toList();
            result.add(new ArrayList<>(list));
        }

        for(int i = idx; i < nums.length; i++){
            swap(nums, idx, i);
            permutations2Helper(nums, result, idx + 1);
            swap(nums, idx, i);
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        System.out.println(permutations2(nums));
    }
}
