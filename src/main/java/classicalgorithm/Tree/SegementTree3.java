package classicalgorithm.Tree;



/**
 * @author huang.fei
 * @version 1.0
 * @description https://codeforces.com/problemset/problem/438/D
 * @date 2022/7/12 22:32
 **/
public class SegementTree3 {

    /**
     * 对某个数字直接进行修改
     * 对某个范围的数字直接求余
     *
     *
     */
    public class Node{
        public int l, r;
        public int sum;
        //  区间内最大数值
        public int maxOfInterval;
    }
    Node[] segementTree;
    int[] numbers;
    public SegementTree3(Node[] segementTree, int[] numbers){
        this.segementTree = segementTree;
        this.numbers = numbers;
    }

    public void buildTree(int treeSubscript, int l, int r){
        if (l == r){
            segementTree[treeSubscript].sum = numbers[l];
            return;
        }
        int mid = l + r >> 1;
        buildTree(treeSubscript * 2, l , mid);
        buildTree(treeSubscript * 2 + 1, mid + 1, r);
        pushUp(treeSubscript);
    }

    private void pushUp(int treeSubscript){
        segementTree[treeSubscript].sum = segementTree[treeSubscript * 2].sum + segementTree[treeSubscript * 2 + 1].sum;
    }

    private void remainderModify(int treeSubscript, int l, int r, int remainder){
        Node presentNode = segementTree[treeSubscript];
        if (presentNode.l <= l && presentNode.r >= r){
            // 所有数字都小于余数 则直接返回
            if (presentNode.maxOfInterval < remainder){
                return;
            }
        }
        if (presentNode.l == presentNode.r){
            presentNode.sum %= remainder;
            presentNode.maxOfInterval %= remainder;
        }
        int mid = presentNode.l + presentNode.r >> 1;
        if (presentNode.l <= mid){
            // 为什么这里的l - r可以不用加以限制 主要是因为在1标记处的代码 做出了限制
            remainderModify(treeSubscript * 2, presentNode.l, presentNode.r, remainder);
        }
        if (presentNode.r > mid){
            remainderModify(treeSubscript * 2, presentNode.l, presentNode.r, remainder);
        }
        pushUp(treeSubscript);
    }

    /**
     *
     * @param treeSubscript
     * @param changeIndex 对单点进行修改
     * @param value
     */
    private void assign(int treeSubscript, int changeIndex,  int value){
        Node presentNode = segementTree[treeSubscript];
        if (presentNode.l == presentNode.r){
            if (presentNode.l == changeIndex){
                presentNode.sum = value;
                presentNode.maxOfInterval = value;
            }
        }
        int mid = presentNode.l + presentNode.r >> 1;
        if (changeIndex <= mid){
            assign(treeSubscript * 2, changeIndex, value);
        }else {
            assign(treeSubscript * 2 + 1, changeIndex, value);
        }
        pushUp(treeSubscript);
    }


    public static void main(String[] args) {
        System.out.println(6 + 6 >> 1);
    }




}
