import java.util.*;
public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombination(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public static void findCombination(int[] canditates, int target, int idx, List<Integer> list, List<List<Integer>> result){
        if(idx == canditates.length){
            if(target == 0){
                result.add(new ArrayList<>(list)); // Note to use new list bc the old will get changed
            }
            return;
        }

        if(canditates[idx] <= target){
            list.add(canditates[idx]);
            findCombination(canditates, target - canditates[idx], idx, list, result);
            list.removeLast();
        }

        findCombination(canditates,  target, idx +  1, list, result);
    }

    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(arr, target));
    }
}
