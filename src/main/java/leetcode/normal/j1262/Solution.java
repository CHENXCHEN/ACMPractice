package leetcode.normal.j1262;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/greatest-sum-divisible-by-three/">1262. 可被三整除的最大和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxSumDivThree(int[] nums) {
        // dp[i][j] -> 当前轮的情况下，取模结果为 j 的最大和是多少
        int[][] dp = {{0, Integer.MIN_VALUE, Integer.MIN_VALUE}, {0, 0, 0}};
        int cur = 0;
        for (int num : nums) {
            cur ^= 1;
            for (int i = 0; i < 3; i++) {
                dp[cur][i] = dp[cur ^ 1][i];
            }
            // 当前轮加上 num 后，取模 3 有 3 种情况，分别计算取模 3 后的结果的总和是多少
            for (int i = 0; i < 3; i++) {
                int next = (i + num) % 3;
                dp[cur][next] = Math.max(dp[cur][next], dp[cur ^ 1][i] + num);
            }
        }
        return dp[cur][0];
    }
}