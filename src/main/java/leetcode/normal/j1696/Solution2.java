package leetcode.normal.j1696;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/jump-game-vi/description/">1696. 跳跃游戏 VI</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        for (int i = 1; i < n; i++) {
            dp[i] = dp[deque.peekFirst()] + nums[i];
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) deque.pollFirst();
            while (!deque.isEmpty() && dp[i] >= dp[deque.peekLast()]) deque.pollLast();
            deque.add(i);
        }
        return dp[n - 1];
    }
}