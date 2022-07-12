package classicalgorithm.Tree;

/**
 * @author huang.fei
 * @version 1.0
 * @description https://www.luogu.com.cn/problem/P3373
 * @date 2022/7/10 19:54
 **/
public class segementTree2{

    public static class Node{
        int l;
        int r;
        // 用于范围求和的因子
        int add;
        int mul;
        // 因子传递是用于计算下个节点的sum的作用
        int sum;

    }

    Node[] segementTree;
    int[] numbers;
    // 结果中需要被求余的因子
    int p;
    public segementTree2(Node[] segementTree, int[] numbers, int p){
        this.segementTree = segementTree;
        this.p = p;
        this.numbers = numbers;
    }

    private void pushUp(int treeSubcript){
        segementTree[treeSubcript].sum = segementTree[treeSubcript * 2].sum + segementTree[treeSubcript * 2 + 1].sum;
    }
    /**
     *
     */
    public void build(int treeSubscript, int l, int r){
        Node presentNode = segementTree[treeSubscript];
        presentNode.l = l;
        presentNode.r = r;
        presentNode.mul = 1;
        if (l == r){
            presentNode.sum = numbers[l];
        }
        int mid = (presentNode.l + presentNode.r) >> 1;
        build(treeSubscript * 2, l, r);
        build(treeSubscript * 2 + 1, l, r);
        pushUp(treeSubscript);
    }

    /**
     * 备注: 乘法会影响到加法因子
     * eg (x + x1) * x2
     * xx2 + x1x2
     *
     * @param treeSubscript
     * @param l
     * @param r
     * @param addFactor
     * @param mulFactor
     */
    public void modify(int treeSubscript, int l, int r, int addFactor, int mulFactor){
        Node presentNode = segementTree[treeSubscript];
        // 递归跳出条件 难点在于因子影响这一段代码
        // eg ((a + x1) * x2 * x3 + x4) * x5如何将该式子分解成addFactor和mulFactor了
        // 拆分成为 加法式子的形势 a * () + ()的形式 ->  ax1x2x4x5 + x1x2x4x5 + x4x5
        // 所以 当有 addFactor和 mulFactor因子的时候
        // ADD : ADD + addFactor
        // MUL = MUL * mulFactor +
        if (l <= presentNode.l && r >= presentNode.r){
            // 有乘法的因子的影响
            presentNode.mul = presentNode.mul * mulFactor % p;
            presentNode.add = presentNode.add * mulFactor % p;
            presentNode.sum = presentNode.sum * mulFactor % p;

            // 加法因子的影响
            presentNode.add = (presentNode.add + addFactor) % p;
            presentNode.sum = presentNode.sum + (r - l + 1) * addFactor;
            return;
        }
        // 标记下传
        pushDown(treeSubscript);



    }

    private void pushDown(int treeSubscript) {
        // 乘法标记下传
        Node presentNode = segementTree[treeSubscript];
        int leftChild = treeSubscript << 1;
        int rightChild = treeSubscript >> 1;
        Node leftNode = segementTree[leftChild];
        Node rightNode = segementTree[rightChild];
        if (presentNode.mul != 1){
            // 标记下传
            // 乘法因子的传递
            leftNode.mul = presentNode.mul * leftNode.mul % p;
            rightNode.mul = presentNode.mul * rightNode.mul % p;

            leftNode.add = presentNode.mul * leftNode.add % p;
            rightNode.add = presentNode.mul * rightNode.add % p;

            leftNode.sum = leftNode.sum * presentNode.mul % p;
            rightNode.sum = rightNode.sum * presentNode.mul % p;
            // 标记恢复
            presentNode.mul = 1;
        }
        if (presentNode.add != 0){
            leftNode.add = (presentNode.add + leftNode.add) % p;
            rightNode.add = (presentNode.add + rightNode.add) % p;
            leftNode.sum = (leftNode.sum + presentNode.add * (leftNode.r - leftNode.l + 1) % p) % p;
            rightNode.sum = (rightNode.sum + rightNode.add * (rightNode.r - rightNode.l + 1) % p) % p;
            presentNode.sum = 0;
        }
    }

    public int query(int treeSubscript, int l, int r){
        Node presentNode = segementTree[treeSubscript];
        // 查找范围的一个小区间被找到
        if (l >= presentNode.l && r <= presentNode.r){
            return presentNode.sum;
        }
        int res = 0;
        // 用于懒加载 只有到达该节点的时候才回去计算孩子节点的因子和总和
        pushDown(treeSubscript);
        int mid = (l + r) >> 1;
        res += query(treeSubscript * 2, l, mid);
        res += query(treeSubscript * 2, mid + 1, r);
        return res;
    }

    public static void main(String[] args) {



    }


}
