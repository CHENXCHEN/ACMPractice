package leetcode.normal.j901;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/online-stock-span/">901. 股票价格跨度</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class StockSpanner {
    ArrayDeque<int[]> deque;
    int idx;

    public StockSpanner() {
        idx = -1;
        deque = new ArrayDeque<>();
        deque.push(new int[]{-1, Integer.MAX_VALUE});
    }

    public int next(int price) {
        ++idx;
        while (price >= deque.peek()[1]) {
            deque.pop();
        }
        int ret = idx - deque.peek()[0];
        deque.push(new int[]{idx, price});
        return ret;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */