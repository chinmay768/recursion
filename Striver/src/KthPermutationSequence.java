import java.util.ArrayList;
import java.util.List;

public class KthPermutationSequence {

    public static String getPermutation(int n, int k){
        int fact = 1;
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < n; i++){
            fact = fact * i;
            list.add(i);
        }
        list.add(n);

        String res = "";
        k = k - 1; // Since it is zero based idx thus we are subtracting 1
        while (true){
            res = res + list.get(k / fact);
            list.remove(k / fact);
            if(list.size() == 0) {
                break;
            }

            k = k % fact;
            fact = fact / list.size();
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 3; int k = 3;

        System.out.println(getPermutation(n, k));
    }
}
