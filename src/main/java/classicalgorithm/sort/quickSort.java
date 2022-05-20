package classicalgorithm.sort;

public class quickSort {

    public void quickSort(int[] nums, int left , int right){
        if (left >= right){
            return;
        }
        int l = left - 1;
        int r = right + 1;
        int mid = nums[left + ((right - left) >> 1)];

        while (l < r){

            do {
                l++;
            }while (nums[l] < mid);

            do {
                r--;
            }while (nums[r] > mid);

            if (l < r){
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
            }
        }
        quickSort(nums, left, r);
        quickSort(nums, r + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = {3,1,7,7,2,9,1,5};
        quickSort quicksort = new quickSort();
        quicksort.quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}
