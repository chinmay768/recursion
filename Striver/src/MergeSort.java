import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr, int start, int end){
        if(start < end){
            int mid = start + ((end - start) / 2);

            mergeSort(arr, start, mid);
            mergeSort(arr, mid +  1, end);

            merge(arr, start, mid, end);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end){
        int[] temp =  new int[end - start + 1];
        int k = 0;

        int left = start;
        int right = mid + 1;

        while (left <= mid && right <= end){
            if(arr[left] <= arr[right]){
                temp[k] = arr[left];
                left++;
            }else {
                temp[k] = arr[right];
                right++;
            }
            k++;
        }

        while (left <= mid){
            temp[k++] = arr[left++];
        }

        while (right <= end){
            temp[k++] = arr[right++];
        }

        for(int i = start; i <= end; i++){
            arr[i] = temp[i - start];
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
