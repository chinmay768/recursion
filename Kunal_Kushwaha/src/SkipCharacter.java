public class SkipCharacter {

    static String skipCharacter(String str, char skipChar){
        if(str.isEmpty()){
            return "";
        }


        if(str.charAt(0) != skipChar){
            return str.charAt(0) + skipCharacter(str.substring(1), skipChar);
        }else{
            return skipCharacter(str.substring(1), skipChar);
        }
    }

    public static void main(String[] args) {
        String str = "Chinmay Sahani";
        System.out.println(skipCharacter(str, 'a'));
    }
}
