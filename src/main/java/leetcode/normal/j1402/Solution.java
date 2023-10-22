package leetcode.normal.j1402;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/reducing-dishes/description/">1402. 做菜顺序</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        // dp[i] -> 到目前为止，前面有 i 个数字的序列最大值是多少
        int n = satisfaction.length;
        int[] dp = new int[n + 1];
        Arrays.sort(satisfaction);
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j > 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - 1] + satisfaction[i] * j);
            }
        }
        int mx = 0;
        for (int i = 1; i <= n; i++) {
            mx = Math.max(mx, dp[i]);
        }
        return mx;
    }
}