package classicalgorithm.sort.n2;

// 选择排序
// 每一轮选择一个最小的数字 放在第多少个 和冒泡反着来的
public class SelectSort {
    // 每一轮选择出最小的数字
    public int[] selectSort(int[] nums){
        for (int i = 0; i < nums.length; i++){
            int min = nums[i];
            int index = i;
            for (int i1 = i + 1; i1 < nums.length; i1++){
                if(nums[i1] < min){
                    index = i1;
                    min = nums[i1];
                }
            }
            int tmp = nums[index];
            nums[index] = nums[i];
            nums[i] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        SelectSort s = new SelectSort();
        int[] nums = {2, 1, 5, 2 ,-1, 9};
        s.selectSort(nums);
        for (int i : nums){
            System.out.println(i);
        }
    }


}
