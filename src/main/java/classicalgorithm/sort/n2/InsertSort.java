package classicalgorithm.sort.n2;

// 插入排序 适用于排序完成性较高的
// 每个数字往前找一个插入位置 然后开始把该位置后面的所有元素移动一个
public class InsertSort {


    public int[] insertSort(int[] nums){
        if (nums.length <= 1){
            return nums;
        }
        for (int i = 1; i < nums.length; i++){
            // 当前元素往前找 找到一个
            int k = 0;
           for (k = 0; k < i; k++){
               if (nums[k] > nums[i]){
                   break;
               }
           }

           if (nums[i] < nums[k]) {
               int tmp = nums[i];
               while (i > k) {
                   nums[i] = nums[i - 1];
                   i--;
               }
               nums[k] = tmp;
           }

        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 1, 15, 8, -1};
        InsertSort i = new InsertSort();
        i.insertSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }


}
