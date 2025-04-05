public class CountGoodNumbers {

    private static long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;
        long first = powRecursive(5, even);
        long second = powRecursive(4, odd);

        return (int)((first * second ) % MOD);
    }

    public static long powRecursive(long x, long n){
        // Whenever you multiply MOD to keep the result in range of data type
        if (n == 0)
            return 1;


        if (n % 2 == 0)
            return powRecursive(x * x % MOD, n / 2);
        else
            return x * powRecursive(x, n - 1) % MOD;
    }

    public static void main(String[] args) {

    }
}
