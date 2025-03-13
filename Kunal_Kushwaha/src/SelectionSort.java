import java.util.Arrays;

public class SelectionSort {

    static void selectionSort(int[] arr, int maxElmIdx, int r, int c){
        if(r == 0){
            return;
        }

        if(c < r){
            if(arr[c] > arr[maxElmIdx]){
                selectionSort(arr, c, r, c +1);
            }else{
                selectionSort(arr, maxElmIdx, r,c + 1);
            }
        }else {
            int temp = arr[maxElmIdx];
            arr[maxElmIdx] = arr[r -1];
            arr[r - 1] = temp;
            selectionSort(arr, 0, r - 1, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 10, 7, 0, 13};

        selectionSort(arr, 0, arr.length, 0);
        System.out.println(Arrays.toString(arr));
    }
}
