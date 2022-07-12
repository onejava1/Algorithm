package classicalgorithm.Tree;

import java.util.Scanner;

/**
 * @author huang.fei
 * @version 1.0
 * @description
 * @date 2022/7/7 22:49
 **/
public class SegementTree1 {
    /**
     * 洛谷3372 https://www.luogu.com.cn/problem/P3372
     * description 给定一个数组
     * 操作 ： 对数组中的一个范围每个数字进行+1
     * 结果 ： 返回数组中任意范围的结果
     * 不可用SegementTree中 单点操作的方法 操作 会从logn 变为 nlogn的复杂度 结果计算复杂度任然还是logn
     */
    public static class Node{
        int l, r;
        // 1表示true 0表示false
        int lazy;
        // 区间和
        int sum;
        Node[] segementTree;
        int[] number;
        public Node(int treeSize, int[] number){
            segementTree = new Node[treeSize];
            this.number = number;
        }

        // 将树的孩子节点数值整合到父节点中
        public void pushUp(int index){
            segementTree[index].sum = segementTree[2 * index + 1].sum + segementTree[2 * index].sum;
        }

        // 建树
        public void buildTree(int indexOfTree, int l, int r){
            segementTree[indexOfTree].l = l;
            segementTree[indexOfTree].r = r;
            if (l == r){
                // 到达了叶子节点
                segementTree[indexOfTree].sum = l;
                return;
            }
            int mid = (l + r) >> 1;

            // 对number区间进行分裂 然后递归到线段树的左右孩子
            buildTree(indexOfTree * 2, l, mid);
            buildTree(indexOfTree * 2 + 1, mid + 1, r);
            // 整合一下到父节点
            pushUp(indexOfTree);
        }

        // 懒标记的传递
        // 标记下传
        public void pushDown(int treeSubscript){
            if (segementTree[treeSubscript].lazy != 0){
                // 左节点标记下传
                segementTree[treeSubscript << 1].lazy += segementTree[treeSubscript].lazy;
                // 计算k对子区间的影响
                segementTree[treeSubscript << 1].sum += (segementTree[treeSubscript << 1].r -
                        segementTree[treeSubscript << 1].l + 1) * segementTree[treeSubscript].lazy;
                segementTree[treeSubscript << 1 + 1].lazy += segementTree[treeSubscript].lazy;
                segementTree[treeSubscript << 1 + 1].sum += (segementTree[treeSubscript << 1 + 1].r -
                        segementTree[treeSubscript << 1 + 1].l + 1) * segementTree[treeSubscript].lazy;

                //当标记下传到左右孩子节点之后 就可以把父节点的数值给清除了
                segementTree[treeSubscript].lazy = 0;
            }
        }

        /**
         *
         * @param treeSubscript
         * @param l
         * @param r
         * @param k 在l - r这个区间之内需要加上的K的数量之和
         */
        public void modify(int treeSubscript, int l, int r, int k){
            if (l <= segementTree[treeSubscript].l && segementTree[treeSubscript].r >= r){
                segementTree[treeSubscript].lazy += k;
                //
                segementTree[treeSubscript].sum += (r - l + 1) * k;
                return;
            }
            // 开始标记下传
            pushDown(treeSubscript);
            int mid = (segementTree[treeSubscript].r + segementTree[treeSubscript].l) >> 1;
            if (l <= mid){
                //
                modify(treeSubscript * 2, l, r, k);
            }
            if (r > mid){
                modify(treeSubscript * 2 + 1, l, r, k);
            }

            pushUp(treeSubscript);
        }

        // 查询l - r范围内的和
        public int query(int treeSubcript, int l, int r){
            if (l <= segementTree[treeSubcript].l && r < segementTree[r].r){
                return segementTree[treeSubcript].sum;
            }
            // 为什么还需要pushDown 是因为需要懒加载 在modify函数中 l - r的范围都需要+K
            // 可能并没有一定走到叶子节点的 所以在查询的时候就需要
            pushDown(treeSubcript);
            int res = 0;
            int mid = (segementTree[treeSubcript].l + segementTree[treeSubcript].r);
            if (l <= mid){
                res += query(treeSubcript * 2, l, r);
            }
            if (r > mid){
                res += query(treeSubcript * 2 + 1, l, r);
            }
            return res;
        }
    }

    public static void main(String[] args) {

    }



}
