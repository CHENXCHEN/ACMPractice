package leetcode.normal.j312;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/burst-balloons/description/">312. 戳气球</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] dp;
    int[] nums;
    int n;

    public int maxCoins(int[] _nums) {
        int n = _nums.length;
        dp = new int[n + 2][n + 2];
        nums = new int[n + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            nums[i + 1] = _nums[i];
        }
        nums[0] = nums[n + 1] = 1;
        return dfs(0, n + 1);
    }

    int dfs(int left, int right) {
        if (right - left <= 1) return 0;
        if (dp[left][right] == -1) {
            int curMax = 0;
            for (int i = left + 1; i < right; i++) {
                curMax = Math.max(curMax, nums[left] * nums[i] * nums[right] + dfs(left, i) + dfs(i, right));
            }
            dp[left][right] = curMax;
        }
        return dp[left][right];
    }

}