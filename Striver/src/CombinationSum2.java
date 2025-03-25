import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findCombination2(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public static void findCombination2(int[] canditates, int target, int idx, List<Integer> list, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(list)); // Note to use new list bc the old will get changed
            return;
        }

        for(int i = idx; i < canditates.length; i++){
            if(i > idx && canditates[i - 1] == canditates[i]) continue;
            if(canditates[i] > target) break; // We are considering the candidates array is sorted

            list.add(canditates[i]);
            findCombination2(canditates, target - canditates[i], i + 1, list, result);
            list.removeLast();
        }
    }


    public static void main(String[] args) {
        int[] arr = {2,2,3,6,7};
        int target = 7;
        System.out.println(combinationSum2(arr, target));
    }
}
