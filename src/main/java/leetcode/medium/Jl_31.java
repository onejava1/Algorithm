package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jl_31 {
    // 很简单 直接根据出栈和压栈的顺序去模拟一次
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        var stack = new ArrayDeque<Integer>();
        int i = 0;
        for (int i1 : pushed) {
            stack.addFirst(i1);
            while (!stack.isEmpty() && popped[i] == stack.peekFirst()){
                stack.removeFirst();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
