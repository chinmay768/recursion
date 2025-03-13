import java.util.ArrayList;

public class StringSubsequence {

    static void printSubsequences(String str, String subSeq){
        if(str.isEmpty()){
            System.out.println(subSeq);
            return;
        }
        printSubsequences(str.substring(1), subSeq);
        printSubsequences(str.substring(1), subSeq + str.charAt(0));
    }

    static ArrayList<String> printSubsequences2(String str, String subSeq){
        if(str.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(subSeq);
            return list;
        }
        ArrayList<String> left = printSubsequences2(str.substring(1), subSeq);
        ArrayList<String> right = printSubsequences2(str.substring(1), subSeq + str.charAt(0));

        left.addAll(right);
        return  left;
    }

    public static void main(String[] args) {
//        printSubsequences("abc", "");
        System.out.println(printSubsequences2("abc", ""));
    }
}
