package leetcode.normal.j3202;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-maximum-length-of-valid-subsequence-ii/description/">3202. 找出有效子序列的最大长度 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length, ans = 1;
        for (int j = 0; j < k; j++) {
            // (x + y) % k = j 的情况数
            int[] dp = new int[k + 1];
            for (int i = 0; i < n; i++) {
                int cur = nums[i] % k, pre = (j - cur + k) % k;
                dp[cur] = Math.max(dp[pre] + 1, dp[cur]);
                ans = Math.max(ans, dp[cur]);
            }
        }
        return ans;
    }
}