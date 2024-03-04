package leetcode.normal.j232;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/implement-queue-using-stacks/description/">232. 用栈实现队列</a>
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class MyQueue {

    ArrayDeque<Integer> deque;
    public MyQueue() {
        deque = new ArrayDeque<>();
    }

    public void push(int x) {
        deque.addLast(x);
    }

    public int pop() {
        return deque.pollFirst();
    }

    public int peek() {
        return deque.peekFirst();
    }

    public boolean empty() {
        return deque.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */