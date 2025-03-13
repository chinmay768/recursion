public class SkipString {

    static String skipString(String str, String skipString){
        if(str.isEmpty()){
            return "";
        }

        if(str.startsWith(skipString)){
            return skipString(str.substring(skipString.length()), skipString);
        }else {
            return str.charAt(0) + skipString(str.substring(1), skipString);
        }
    }

    public static void main(String[] args) {
        String skipString = "apple";

        System.out.println(skipString("This is an apple and its color is red.", skipString));
    }
}
