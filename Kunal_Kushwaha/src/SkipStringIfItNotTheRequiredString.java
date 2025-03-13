public class SkipStringIfItNotTheRequiredString {

    static String skipAppNotApple(String str, String skipString){
        if(str.isEmpty()){
            return "";
        }

        if(str.startsWith(skipString) && !str.startsWith("apple")){
            return skipAppNotApple(str.substring(skipString.length()), skipString);
        }else {
            return str.charAt(0) + skipAppNotApple(str.substring(1), skipString);
        }
    }

    public static void main(String[] args) {
        System.out.println(skipAppNotApple("This app belongs to apple.", "app"));
    }
}
