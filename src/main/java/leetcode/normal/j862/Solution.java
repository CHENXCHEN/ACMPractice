package leetcode.normal.j862;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k/">862. 和至少为 K 的最短子数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) preSum[i + 1] = preSum[i] + nums[i];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int ans = n + 1;
        for (int i = 0; i <= n; i++) {
            long curSum = preSum[i];
            // 如果满足这个条件，那么我们就找到了以 deque.peekFirst() 为起点的最短长度
            while (!deque.isEmpty() && curSum - preSum[deque.peekFirst()] >= k) {
                ans = Math.min(ans, i - deque.pollFirst());
            }
            // 如果满足这个条件，preSum[j] >= preSum[i], j < i < x,
            // 我们有 preSum[x] - preSum[i] >= preSum[x] - preSum[j]，我们可以把 j 安全的给移除掉
            while (!deque.isEmpty() && preSum[deque.peekLast()] >= curSum) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return ans == n + 1 ? -1 : ans;
    }
}