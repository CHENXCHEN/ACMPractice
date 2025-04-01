package leetcode.normal.j2140;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/solving-questions-with-brainpower/description/">2140. 解决智力问题</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        // dp[i] 表示解决 [i..n-1] 的问题可以获得的最大分数
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], questions[i][0] + dp[Math.min(i + questions[i][1] + 1, n)]);
        }
        return dp[0];
    }
}