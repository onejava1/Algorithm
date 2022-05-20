package classicalgorithm.sort.n2;


//将最大的浮在最上面去 一次类推
public class BubbleSort {
    public int[] bubbleSort(int[] nums){
        for (int i = 0; i < nums.length; i++){
            for (int i1 = 0; i1 < nums.length - i - 1; i1++){
                if (nums[i1] > nums[i1 + 1]){
                    int tmp = nums[i1 + 1];
                    nums[i1 + 1] = nums[i1];
                    nums[i1] = tmp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 2 ,-1, 9};
        BubbleSort s = new BubbleSort();
        s.bubbleSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
