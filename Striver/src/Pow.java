public class Pow {

    public static double powNaive(double x, int n){
        double res = 1;
        for(int i = 1; i <= n; i++){
            res = res * x;
        }

        return res;
    }

    public static double powRecursive(double x, int n){
        // Note on leetcode there's a case where n = -2147483648  so to tackle that cast n into long return powRecursive(x, (long) n);
        if (n == 0)
            return 1;
        if (n < 0)
            return 1 / powRecursive(x, Math.abs(n));

        if (n % 2 == 0)
            return powRecursive(x * x, n / 2);
        else
            return x * powRecursive(x, n - 1);
    }

    public double myPowIterative(double x, long n) {
        if(n < 0) {
            x = 1 / x;
            n = -n;
        }

        double result = 1;
        double current_product = x;

        while(n > 0) {
            if(n % 2 == 1) {
                result = result * current_product;
            }
            current_product = current_product * current_product;
            n = n / 2;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(powRecursive(2.00000, -214648));
    }
}
