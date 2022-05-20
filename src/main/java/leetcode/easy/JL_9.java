package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class JL_9 {
    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();
    public void appendTail(int value) {
        stack1.addFirst(value);
    }

    public int deleteHead() {
        while (!stack2.isEmpty()){
            return stack2.removeFirst();
        }
        while (!stack1.isEmpty()){
            stack2.addFirst(stack1.removeFirst());
        }
        return stack2.isEmpty() ? -1 : stack2.removeFirst();
    }

}
