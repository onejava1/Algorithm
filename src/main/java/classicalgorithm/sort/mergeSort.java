package classicalgorithm.sort;

/**
 * 归并排序
 */
public class mergeSort {

    public void mergeSort(int[] nums, int left, int right){
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }
    private void merge(int[] nums, int left, int mid, int right){
        // 创建一个临时数组用于存储归并后的结果
        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        // 左段和右段 进行归并
        while (i <= mid && j <= right){
            tmp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }

        while (i <= mid){
            tmp[k++] = nums[i++];
        }
        while (j <= right){
            tmp[k++] = nums[j++];
        }
        for (int i1 = 0, i2 = left; i1 < tmp.length; i1++, i2++) {
            nums[i2] = tmp[i1];
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, -2, 9, 10, 18, 7, 2, 2};
        mergeSort mergeSort = new mergeSort();
        mergeSort.mergeSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


}
