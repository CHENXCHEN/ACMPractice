package leetcode.normal.j1429;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/first-unique-number/description/">1429. 第一个唯一数字</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class FirstUnique {
    ArrayDeque<Integer> deque = new ArrayDeque<>();
    Map<Integer, Integer> cnt = new HashMap<>();

    public FirstUnique(int[] nums) {
        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        while(!deque.isEmpty() && cnt.getOrDefault(deque.peek(), 0) > 1) {
            deque.poll();
        }
        return deque.isEmpty() ? -1 : deque.peek();
    }

    public void add(int value) {
        cnt.compute(value, (k, v) -> v == null ? 1 : v + 1);
        deque.addLast(value);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */