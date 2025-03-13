public class ReverseNumber {

     static int sum = 0;
     static void reverse(int num){
        if(num == 0){
            return;
        }

        int rem = num % 10;
        sum = (sum * 10) + rem;
        num /= 10;
        reverse(num);
    }

    public static void main(String[] args) {
        reverse(98214);
        System.out.println(sum);
    }
}
