package leetcode.normal.j3251;

/**
 * Created by CHENXCHEN
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    // dp[i][j] 表示当 nums1[i] 为 j 时，长度为 [0...i] 的有多少种组合方式
    //          若 nums1[i] 的值确定了，那么 nums2[i] 的值也是确定的
    // dp[i][j] = sum(dp[i-1][0...k])
    // k 需要满足(尽量减少引入新变量)：
    //  1. 满足 nums1 的非递减规则：k <= j
    //  2. 满足 nums2 的非递增规则：nums[i-1] - k >= nums[i] - j >= 0
    //                           j >= k + nums[i] - nums[i-1], 令 d = max(nums[i] - nums[i-1], 0)
    //                        则：j >= k + d，可得 k <= j - d
    // 考虑 dp[i][j] 与 dp[i][j-1] 的关系： dp[i][j] = sum(dp[i-1][0..(j-d)]), dp[i][j-1] = sum(dp[i-1][0..(j-d-1)]
    // 可以看出 dp[i][j] - dp[i][j-1] = dp[i-1][j-d], dp[i][j] = dp[i][j-1] + dp[i - 1][j-d]
    int MOD = (int) 1e9 + 7;

    public int countOfPairs(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][1001];
        for (int i = 0; i <= nums[0]; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            int d = Math.max(nums[i] - nums[i - 1], 0);
            for (int j = d; j <= nums[i]; j++) {
                dp[i][j] = dp[i - 1][j - d];
                if (j != 0) dp[i][j] += dp[i][j - 1];
                dp[i][j] %= MOD;
            }
        }
        int ans = 0;
        for (int i = 0; i <= nums[n - 1]; i++) {
            ans = (ans + dp[n - 1][i]) % MOD;
        }
        return ans;
    }
}
