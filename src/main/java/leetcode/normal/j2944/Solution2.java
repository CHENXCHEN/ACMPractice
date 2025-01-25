package leetcode.normal.j2944;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-coins-for-fruits/description/">2944. 购买水果需要的最少金币数</a>
 * 题目描述容易理解错，注意题目描述的下标是从 1 开始的
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        // dp[i] 表示若买下标为 i 的水果，买完 [i,n] 的所有水果，最小花费的金币是多少
        int[] dp = new int[n + 2];
        // 若必须买第 idx 的水果，那么第 [idx+1,2*idx] 的水果都能免费获得，并且一定要买第 2*idx+1 的水果
        // 若必须买第 idx 的水果，要使得 [idx,n] 都被买了，必须要买一个，这个的范围必须在 [idx+1,2*idx+1] 之间
        // dp[i] = min(dp[j]) i+1 <= j <= 2i+1，使用优先队列来维护连续数组的最小值
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(n + 1);
        for (int i = n; i > 0; i--) {
            int maxRight = 2 * i + 1;
            while (deque.peekLast() > maxRight) deque.pollLast();
            dp[i] = dp[deque.peekLast()] + prices[i - 1];
            while (!deque.isEmpty() && dp[i] < dp[deque.peekFirst()]) {
                deque.poll();
            }
            deque.addFirst(i);
        }
        return dp[1];
    }
}