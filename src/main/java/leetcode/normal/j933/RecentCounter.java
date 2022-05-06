package leetcode.normal.j933;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/number-of-recent-calls/
 * 933. 最近的请求次数
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class RecentCounter {
    ArrayDeque<Integer> deque;
    public RecentCounter() {
        deque = new ArrayDeque<>();
    }

    public int ping(int t) {
        deque.addLast(t);
        while (deque.getFirst() < t - 3000) {
            deque.removeFirst();
        }
        return deque.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */