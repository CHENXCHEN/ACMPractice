package leetcode.normal.j3250;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    // dp[i][j] 表示当 nums1[i] 为 j 时，长度为 [0...i] 的有多少种组合方式
    //          若 nums1[i] 的值确定了，那么 nums2[i] 的值也是确定的
    // dp[i][j] = sum(dp[i-1][0...k]), k <= nums[i-1]
    int[][] dp;
    int[] nums;
    int MOD = (int) 1e9 + 7;

    public int countOfPairs(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        dp = new int[n + 1][51];
        for (int i = 0; i <= n; i++) Arrays.fill(dp[i], -1);
        return dfs(n, nums[n - 1], 0);
    }

    int dfs(int pos, int num1, int num2) {
        if (pos == 0) {
            return 1;
        }
        if (dp[pos][num1] != -1) return dp[pos][num1];
        int res = 0;
        int mx = Math.min(Math.min(nums[pos - 1], num1), nums[pos - 1] - num2);
        // num1 的下一个节点不超过 min(nums[pos - 1], num1)
        // num2 的下一个节点，当 num1 为 i 时，必须满足
        //      nums[pos - 1] - i >= num2
        // =>   nums[pos - 1] - nums2 >= i
        for (int i = 0; i <= mx; i++) {
            res = (res + dfs(pos - 1, i, nums[pos - 1] - i)) % MOD;
        }
        dp[pos][num1] = res;
        return res;
    }
}
