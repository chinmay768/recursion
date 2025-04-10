import java.util.*;
public class LetterCasePermutation {

    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        char[] charArr = s.toCharArray();
        generatePermutations(s, 0, result, charArr);

        return result;
    }

    public static void generatePermutations(String s, int idx, List<String> result, char[] charArr){
        if(idx == s.length()){
            result.add(new String(charArr));
            return;
        }

        // Skip
        generatePermutations(s, idx + 1, result, charArr);

        // Permute if charAt(idx) is a char
        if(Character.isLetter(charArr[idx])){
            charArr[idx] ^= ' ';
            generatePermutations(s, idx + 1, result, charArr);
            charArr[idx] ^= ' ';
        }
    }

    public static void main(String[] args) {
        String str = "a1b2";

        System.out.println(letterCasePermutation(str));
    }
}
