public class CountInversions {

    public static int countInversionsNaive(int[] nums){
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] > nums[j]){
                    count++;
                }
            }
        }

        return count;
    }

    public static Integer mergeSort(int[] nums, int start, int end){
        if(start < end){
            int mid = start + (end - start) / 2;

            int leftInversionCount = mergeSort(nums, start, mid); // Will return the inversion count form left parition
            int rightInversionCount = mergeSort(nums, mid + 1, end); // from right

            int currInversionCount = merge(nums, start, mid, end);
            return leftInversionCount + rightInversionCount + currInversionCount;
        }
        return 0;
    }

    public static int merge(int[] nums, int start, int mid, int end){
        int inversionCount = 0;
        int left = start;
        int right = mid + 1;

        int[] temp = new int[end - start + 1];
        int k = 0;
        while (left <= mid && right <= end){
            if(nums[left] <= nums[right]){
                temp[k] = nums[left];
                k++;
                left++;
            }else{
                temp[k] = nums[right];
                inversionCount += mid - left + 1;
                right++;
                k++;
            }
        }

        while (left <= mid){
            temp[k++] = nums[left++];
        }

        while (right <= end){
            temp[k++] = nums[right++];
        }

        for(int i = 0; i < temp.length; i++){
            nums[start + i] = temp[i];
        }

        return inversionCount;
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 5, 2, 7};

//        System.out.println(countInversionsNaive(arr));
        System.out.println(mergeSort(arr, 0, arr.length - 1));
    }
}
