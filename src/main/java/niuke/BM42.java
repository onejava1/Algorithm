package niuke;

import java.util.Stack;

/**
 *
 *
 * @author huang.fei
 * @version 1.0
 * @description 两个栈实现队列
 * @date 2022/6/11 16:24
 **/
public class BM42 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    // 加入一个节点
    public void push(int node) {
        stack1.add(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                Integer pop = stack1.pop();
                stack2.add(pop);
            }
        }
        return stack2.pop();
    }


}
