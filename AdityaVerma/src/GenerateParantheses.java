import java.util.*;
public class GenerateParantheses {

    //TC: O(2^n * n)
    //SC: O(2n * k) k is no of valid strings
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n,0, 0, new StringBuilder(), ans);
        return ans;
    }

    public static void generate(int n, int lCount, int rCount, StringBuilder sb, List<String> result){
        if(lCount < rCount || lCount > n){ //Invalid Cases
            return;
        }

        if(lCount == n && rCount == n){
            result.add(new String(sb));
            return;
        }

        sb.append("(");
        generate(n, lCount + 1, rCount, sb, result);
        sb.deleteCharAt(sb.length() - 1);

        if(rCount < lCount){
            sb.append(")"); // Remember if you manipulate sb then you don't need to reassign it like in string
            generate(n, lCount, rCount + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
}
