package niuke.huawei;

/**
 * 射击训练，需要给每个士兵发子弹，发子弹的个数规则是根据士兵的训练成绩给定的，传入士兵的训练成绩，
 * 要求相邻士兵中，成绩好的士兵的子弹数必须更多，每个士兵至少分配一个子弹。
 */
public class fenzidan {

    public int total(int[] nums){
        // 现在的子弹数目
        int nowIndex = 1;
        // 总的子弹数目
        int sum = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]){
                nowIndex += 1;
                sum += nowIndex;
            }
            if(nums[i] ==  nums[i - 1]){
                sum += nowIndex;
            }
            if(nums[i] < nums[i - 1]){
                sum += 1;
                nowIndex = 1;
            }
        }
        return sum;

    }


}
