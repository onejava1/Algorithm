package classicalgorithm.Tree;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Deque;

public class AvlTree<T extends Comparable<T>> {

    // avl树的节点
    class AVLTreeNode<T extends Comparable<T>> {
        T key;                // 关键字(键值)
        int height;         // 高度
        AVLTreeNode<T> left;    // 左孩子
        AVLTreeNode<T> right;    // 右孩子

        public AVLTreeNode(T key, AVLTreeNode<T> left, AVLTreeNode<T> right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    AVLTreeNode<T> mRoot;

    private int height(AVLTreeNode<T> tree) {
        if (tree != null) {
            return tree.height;
        }
        return 0;
    }


    // ll类型
    private AVLTreeNode<T> leftLeftRotation(AVLTreeNode<T> k2) {
        AVLTreeNode<T> k1;
        k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    // rr型
    private AVLTreeNode<T> rightRightRotation(AVLTreeNode<T> k1) {
        AVLTreeNode<T> k2;
        k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;
        return k2;
    }

    /*
     * LR：左右对应的情况(左双旋转)。
     *
     * 返回值：旋转后的根节点
     */
    private AVLTreeNode<T> leftRightRotation(AVLTreeNode<T> k3) {
        k3.left = rightRightRotation(k3.left);
        return leftLeftRotation(k3);
    }

    /*
     * RL：右左对应的情况(右双旋转)。
     *
     * 返回值：旋转后的根节点
     */

    private AVLTreeNode<T> rightLeftRotation(AVLTreeNode<T> k1) {
        k1.right = leftLeftRotation(k1.right);
        return rightRightRotation(k1);
    }

    //
    private AVLTreeNode<T> insert(AVLTreeNode<T> tree, T key) {
        if (tree == null) {
            // 新建节点
            tree = new AVLTreeNode<T>(key, null, null);
            if (tree == null) {
                System.out.println("ERROR: create avltree node failed!");
                return null;
            }
        }
        else {
            int cmp = key.compareTo(tree.key);
            if (cmp < 0) {
                // 应该将key插入到"tree的左子树"的情况
                tree.left = insert(tree.left, key);
                // 插入节点后，若AVL树失去平衡，则进行相应的调节。
                if (height(tree.left) - height(tree.right) == 2) {
                    if (key.compareTo(tree.left.key) < 0) {
                        // ll类型
                        tree = leftLeftRotation(tree);
                    } else {
                        // lr类型
                        tree = leftRightRotation(tree);
                    }
                }
            }
            else if (cmp > 0) {    // 应该将key插入到"tree的右子树"的情况
                tree.right = insert(tree.right, key);
                    // 插入节点后，若AVL树失去平衡，则进行相应的调节。
                if (height(tree.right) - height(tree.left) == 2) {
                    if (key.compareTo(tree.right.key) > 0) {
//                            rr类型
                        tree = rightRightRotation(tree);
                    } else {
                            // rl类型
                        tree = rightLeftRotation(tree);
                    }
                }
            }
            else {    // cmp==0
                System.out.println("添加失败：不允许添加相同的节点！");
            }
        }
        tree.height = Math.max(height(tree.left), height(tree.right)) + 1;
        return tree;
    }

    public void insert(T key) {
        mRoot = insert(mRoot, key);
    }

    public void inOrder(AVLTreeNode node){
        Deque<AVLTreeNode> queue = new ArrayDeque<>();
        AVLTreeNode tmp = node;
        while (!queue.isEmpty() || tmp != null){
            while (tmp != null){
                queue.addFirst(tmp);
                tmp = tmp.left;
            }
            AVLTreeNode avlTreeNode = queue.removeFirst();
            if (avlTreeNode.right != null){
                System.out.println(avlTreeNode.key);
                tmp = avlTreeNode.right;
            }else {
                //
                System.out.println(avlTreeNode.key);
                tmp = null;
            }
        }
    }

    public static void main(String[] args) {
//        AVLTree<Integer> avlTree = new AVLTree<>();
        AvlTree<Integer> avlTree = new AvlTree<>();
        avlTree.insert(10);
        avlTree.insert(13);
        avlTree.insert(9);
        avlTree.insert(5);
        avlTree.insert(8);
        avlTree.insert(18);
        avlTree.insert(12);
        avlTree.inOrder(avlTree.mRoot);
    }
}