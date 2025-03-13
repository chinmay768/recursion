import java.util.ArrayList;

public class KeypadCombinations {

    static void pad(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }

        int digit = unprocessed.charAt(0) - '0'; // This will convert '2' into 2
        for(int i = (digit - 1) * 3; i < digit * 3; i++){
            char ch = (char) ('a' + i);
            pad(processed + ch, unprocessed.substring(1));
        }
    }

    static ArrayList<String> padRet(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        int digit = up.charAt(0) - '0';
        for(int i = (digit - 1) * 3; i < digit * 3; i++){
            char ch = (char) ('a' + i);
            list.addAll(padRet(p + ch, up.substring(1)));
        }

        return list;
    }


    static int padCount(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            return 1;
        }

        int count = 0;

        int digit = unprocessed.charAt(0) - '0'; // This will convert '2' into 2
        for(int i = (digit - 1) * 3; i < digit * 3; i++){
            char ch = (char) ('a' + i);
            count += padCount(processed + ch, unprocessed.substring(1));
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(padCount("","12"));
    }
}
