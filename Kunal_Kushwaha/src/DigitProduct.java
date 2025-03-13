public class DigitProduct {
    static int digitProduct(int num){
        if(num % 10 == num){
            return  num;
        }

        return (num % 10) * digitProduct(num/10);
    }

    public static void main(String[] args) {
        System.out.println(digitProduct(1234));
    }
}
