package leetcode.normal.j641;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/design-circular-deque/">641. 设计循环双端队列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class MyCircularDeque {
    int[] deque;
    int front, tail;

    public MyCircularDeque(int k) {
        deque = new int[k + 1];
        front = tail = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        deque[front] = value;
        front = subPos(front);
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        tail = addPos(tail);
        deque[tail] = value;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = addPos(front);
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail = subPos(tail);
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return deque[addPos(front)];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return deque[tail];
    }

    public boolean isEmpty() {
        return front == tail;
    }

    public boolean isFull() {
        return addPos(tail) == front;
    }

    int addPos(int pos) {
        return pos + 1 == deque.length ? 0 : pos + 1;
    }

    int subPos(int pos) {
        return pos == 0 ? deque.length - 1 : pos - 1;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */