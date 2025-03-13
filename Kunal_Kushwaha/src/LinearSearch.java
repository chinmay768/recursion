public class LinearSearch {

    static boolean search(int[] arr, int target, int idx){
        if(idx >= arr.length){
            return false;
        }

        return arr[idx] == target || search(arr, target, idx + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 18, 2, 9, 10, 11};
        System.out.println(search(arr, 8, 0));
    }
}
