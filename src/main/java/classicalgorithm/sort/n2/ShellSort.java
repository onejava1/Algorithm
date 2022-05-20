package classicalgorithm.sort.n2;

//插入排序的改进被称作为分组插入排序
public class ShellSort {

    //希尔排序
    public  void shellSort(int[] array) {
        int gap = array.length;//分组的个数
        while (true) {
            //
            gap = gap / 3 + 1;
            insertSortWithGap(array, gap);//分组的插入排序
            if (gap == 1) {
                return;
            }
        }

    }

    //每组的组内插入排序
    private  void insertSortWithGap(int[] array, int gap) {
        //
        for (int i = 0; i < array.length - gap; i++) {//假设前gap组已经有序，所以只循环arr.length-gap次
            int key = array[i + gap];//组内排序
            int j;
            for (j = i; j >= 0 && key < array[j]; j -= gap) {
                array[j + gap] = array[j];
            }
            array[j + gap] = key;
        }
    }


    public static void main(String[] args) {
        ShellSort s = new ShellSort();
        int[] nums = {2, 1, 5, 2, -1, 9};
        s.shellSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
