public class KthSymbolInGrammar {

    public static int kthGrammar(int n, int k) {
        if(n == 1){
            return 0;
        }

        int parent = kthGrammar(n - 1, (int) Math.ceil(k / 2D)); // Note to take table in intermediate divisions to keep the decimal values
        Boolean isKOdd = k % 2 == 1;

        if(parent == 1) {
            return (isKOdd)? 1 : 0;
        }else {
            return (isKOdd)? 1 : 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(kthGrammar(3, 1));
    }
}
