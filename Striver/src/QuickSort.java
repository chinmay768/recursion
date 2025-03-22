import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr,  int low, int high){
        if(low < high){
            int pi =  parition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi +  1, high);
        }
    }

    public static int parition(int[] arr, int low, int high){
        int pivot = arr[high];

        int k = low - 1;
        for(int i = low; i < high; i++){ // start i form low as we are using the same array
            if(arr[i] < pivot){
                k++;
                swap(arr, k, i);
            }
        }

        // At this point k will be point to the last elm smaller than pivot so k + 1 is the idx where pivot actually belongs
        swap(arr, k + 1, high);
        return k + 1;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
