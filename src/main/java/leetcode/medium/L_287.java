package leetcode.medium;
// todo 待做
public class L_287 {

    int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);
        return slow;

    }

    public static void main(String[] args) {
        L_287 l_287 = new L_287();
        int[] nums = {1,4,6,6,6,2,3};
        int duplicate = l_287.findDuplicate(nums);
        System.out.println(duplicate);

    }
}
