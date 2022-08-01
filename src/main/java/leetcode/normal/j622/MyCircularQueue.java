package leetcode.normal.j622;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/design-circular-queue/">622. 设计循环队列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class MyCircularQueue {

    int[] queue;
    int head, tail;

    public MyCircularQueue(int k) {
        queue = new int[k + 1];
        head = tail = 0;
    }

    int nextPos(int pos) {
        return pos == queue.length - 1 ? 0 : pos + 1;
    }

    int prePos(int pos) {
        return pos == 0 ? queue.length - 1 : pos - 1;
    }

    public boolean enQueue(int value) {
        int next = nextPos(tail);
        if (next == head) return false;
        queue[tail] = value;
        tail = next;
        return true;
    }

    public boolean deQueue() {
        if (head == tail) return false;
        head = nextPos(head);
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return queue[head];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return queue[prePos(tail)];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return nextPos(tail) == head;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */