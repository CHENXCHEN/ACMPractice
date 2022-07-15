package leetcode.normal.j2518;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/qIsx9U/">剑指 Offer II 041. 滑动窗口的平均值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class MovingAverage {
    int[] deque;
    int tail, size, sum, cnt;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        deque = new int[size];
        this.size = size;
        tail = 0;
    }

    public double next(int val) {
        tail = tail + 1 == size ? 0 : tail + 1;
        sum -= deque[tail];
        deque[tail] = val;
        sum += val;
        if (cnt != size) cnt++;
        return sum * 1.0 / cnt;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */