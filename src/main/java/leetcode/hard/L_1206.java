package leetcode.hard;

/**
 * 跳表的实现
 */
public class L_1206 {
    public class Node{
        Integer value;
        Node[] next;
        public Node(Integer value, int size){
            this.value = value;
            next = new Node[size];
        }
    }
    private static final int DEFAULTT_MAX_LEVEL = 32;
    //  随机层数概率，也就是随机出的层数，在 第1层以上(不包括第一层)的概率，层数不超过maxLevel，层数的起始号为1
    private static final double DEFAULT_P_FACTORY = 0.25;

    // 创建一个拥有32层高的头节点
    Node head = new Node(null, DEFAULTT_MAX_LEVEL);

    // 除开头节点的最高层
    int currentLevel = 1;


    public boolean search(int target){
        Node searchNode = head;
        for (int i = currentLevel - 1; i >= 0; i--){
            searchNode = findcloest(searchNode, target, i);
            // 层最后一个都不是 则无
            if (searchNode.next[i].value != null && searchNode.next[i].value == target){
                return true;
            }
        }
        return false;
    }

    public void add(int num){
        int level = randomLevel();
        Node tmp = head;
        Node newNode = new Node(num, level);
        for (int i = currentLevel - 1; i >= 0; i--){
            // 从最上层开始找离num最近的
            tmp = findcloest(tmp, num, i);
            if (i < level){
                // 直接插入的将会是最后一个数值
                if (tmp.next[i] == null){
                   tmp.next[i] = newNode;
                }else {
                    // 在中间
                    Node next = tmp.next[i];
                    tmp.next[i] = newNode;
                    newNode.next[i] = next;
                }
            }
        }
        // 将头指针的每一层和相应的当前最高层相对应
        if (level > currentLevel){
            for (int i = currentLevel; i < level; i++) {
                head.next[i] = newNode;
            }
        }
    }

    // 擦除erase
    public boolean erase(int num) {
        boolean flag = false;
        Node searchNode = head;
        for (int i = currentLevel-1; i >=0; i--) {
            searchNode = findcloest(searchNode, i, num);
            if (searchNode.next[i]!=null && searchNode.next[i].value == num){
                //找到该层中该节点
                searchNode.next[i] = searchNode.next[i].next[i];
                flag = true;
                continue;
            }
        }
        return flag;
    }



    // 创建的每个节点的随机层高 至少这是在redis中是如此实现的
    private int randomLevel(){
        int level = 1;
        while (Math.random() < DEFAULT_P_FACTORY && level < DEFAULTT_MAX_LEVEL){
            level++;
        }
        return level;
    }

    // 在当层寻找到等于target的节点或者小于target的最近节点
    private Node findcloest(Node node,int taget, int level){
        Node tmp = node;
        while (tmp.next[level] != null && tmp.next[level].value < taget) {
            tmp = head.next[level];
        }
        return tmp;
    }

}
