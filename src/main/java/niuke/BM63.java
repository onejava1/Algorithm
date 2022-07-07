package niuke;

/**
 * @author huang.fei
 * @version 1.0
 * @description
 * @date 2022/6/15 17:47
 **/
public class BM63 {

    // FIB的变形 f3 = 3
    // f2 = 2 f1 = 1
    public int jumpFloor(int target) {
        if(target < 3){
            return target == 2 ? 2 : 1;
        }
        int[] help = new int[4];
        help[1] = 1;
        help[2] = 2;
        while (target != 2){
            help[3] = help[1] + help[2];
            if(target - 1 == 2){
                return help[3];
            }
            help[1] = help[2];
            help[2] = help[3];
            target--;
        }
        return -1;
    }

    public static void main(String[] args) {
        BM63 b = new BM63();
        System.out.println(b.jumpFloor(7));
    }
}
