import java.util.Arrays;

public class SortColors {

    public static void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        int k = 0;
        while(k <= end){
            if(nums[k] == 0){
                swap(nums, start, k);
                start++;
                k++;
            }else if(nums[k] == 2){
                swap(nums, k, end);
                end--;
            }else if(nums[k] == 1){
                k++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr =  {2,0,2,1,1,0};

        sortColors(arr);

        System.out.println(Arrays.toString(arr));
    }
}
