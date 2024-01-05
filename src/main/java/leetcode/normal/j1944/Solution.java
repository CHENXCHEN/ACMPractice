package leetcode.normal.j1944;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-visible-people-in-a-queue/description/">1944. 队列中可以看到的人数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            int cnt = 0;
            while (!deque.isEmpty() && deque.peek() <= heights[i]) {
                ++cnt;
                deque.pop();
            }
            if (!deque.isEmpty()) ++cnt;
            ans[i] = cnt;
            deque.push(heights[i]);
        }
        return ans;
    }
}