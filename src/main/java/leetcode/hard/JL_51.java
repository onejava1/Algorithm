package leetcode.hard;

/**
 * 数组中的逆序对
 */
public class JL_51 {

    int time = 0;
    // 逆序对经典解法是采用归并排序算法
    // 主要原因在于
    public int reversePairs(int[] nums) {
        // 从大到小的去排序
        mergeSort(nums, 0, nums.length - 1);
        return time;
    }
    private void mergeSort(int[] nums, int left, int right){
        if (left >= right){
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merget(nums, left, mid, right);
    }
    private void merget(int[] nums, int left, int mid, int right){
        int[] tmp = new int[right - left + 1];
        int lstart = left;
        int rstart = mid + 1;
        int k = 0;
        while (lstart <= mid && rstart <= right){
            if (nums[lstart] > nums[rstart]){
                tmp[k++] = nums[lstart++];
                time += right - rstart + 1;
            }else {
                tmp[k++] = nums[rstart++];
            }
        }
        while (lstart <= mid){
            tmp[k++] = nums[lstart++];
        }
        while (rstart <= right){
            tmp[k++] = nums[rstart++];
        }
        for (int i = 0, i1 = left; i < tmp.length;i++){
            nums[i1++] = tmp[i];
        }
    }

    public static void main(String[] args) {
        JL_51 l = new JL_51();
        int[] ac = {7, 3, 2, 6, 0, 1, 5, 4};
        System.out.println(l.reversePairs(ac));
    }

}
