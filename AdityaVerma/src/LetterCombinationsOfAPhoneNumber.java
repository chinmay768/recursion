import java.util.*;

import static java.util.Map.entry;

public class LetterCombinationsOfAPhoneNumber  {

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        Map<Integer, char[]> phone = Map.ofEntries( // Java 9 or above
                entry(2, new char[]{'a', 'b', 'c'}),
                entry(3, new char[]{'d', 'e', 'f'}),
                entry(4, new char[]{'g', 'h', 'i'}),
                entry(5, new char[]{'j', 'k', 'l'}),
                entry(6, new char[]{'m', 'n', 'o'}),
                entry(7, new char[]{'p', 'q', 'r', 's'}),
                entry(8, new char[]{'t', 'u', 'v'}),
                entry(9, new char[]{'w', 'x', 'y', 'z'})
        );

        generateCominations(digits, 0, "", result, phone);
        return result;
    }

    public static void generateCominations(String digits, int idx, String curr, List<String> result, Map<Integer, char[]> phone){
        if(idx == digits.length()){
            if(!curr.isEmpty()) result.add(curr); // To handle case where input string digits is empty
            return;
        }

        // Here we needed an Object of type Integer so we did this bc str.charAt(idx) won't work
        char[] keys = phone.get(Integer.parseInt(String.valueOf(digits.charAt(idx))));

        for(int i = 0; i < keys.length; i++){
            generateCominations(digits, idx + 1, curr + keys[i], result, phone);
        }
    }

    public static void main(String[] args) {
//        Map<Integer, char[]> map = new HashMap<>(){{ // Java 8
//            put(2, new char[]{'1', '2'});
//        }};

        System.out.println(letterCombinations("249"));
    }


}
