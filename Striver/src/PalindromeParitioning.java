import java.util.*;
public class PalindromeParitioning {

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> currPartition = new ArrayList<>();

        partitionHelper(s, 0, result, currPartition);

        return result;
    }

    public static void partitionHelper(String s, int idx, List<List<String>> result, List<String> currPartition){
        if(idx == s.length()){
            result.add(new ArrayList<>(currPartition));
            return;
        }

        for(int i = idx; i < s.length(); i++){
            if(isPalindrome(s, idx, i)){
                currPartition.add(s.substring(idx, i+1));
                partitionHelper(s, i + 1, result, currPartition);
                currPartition.removeLast();
            }
        }
    }

    public static boolean isPalindrome(String s, int startIdx, int endIdx){
        while (startIdx < endIdx){
            if(s.charAt(startIdx++) != s.charAt(endIdx--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "aab";
        List<List<String>> result = partition(str);
        for (int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }
    }
}
