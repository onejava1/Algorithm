package interviewtest;

import com.sun.tools.javac.Main;

public class FindMost {
    // 保证这个赋值的占位的数字必须就是数组范围之外的
    public static int getMost(int[] array){
        int pre = 0;
        for (int i = 1; i < array.length; i++){
            if (array[i] == array[pre] && i != pre){
                continue;
            }else if (array[i] != array[pre]){
                array[i] = -1;
                array[pre] = -1;
                while (array[pre] == -1){
                    pre++;
                }
            }
        }
        for (int i = 1; i < array.length; i++){
            if (array[i] != -1){
                return array[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] help = {2, 3, 3, 3, 1};
        System.out.println(getMost(help));
    }
}
