public class IsSortedArray {

    static boolean isSortedArray(int[] arr, int idx){
        if(idx+ 1 >= arr.length){
            return true;
        }

        if(arr[idx] < arr[idx + 1]){
            return isSortedArray(arr, idx + 1);
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 9, 4, 5, 6, 7};
        System.out.println(isSortedArray(arr, 0));
    }
}
