package leetcode.normal.j3578;

import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-partitions-with-max-min-difference-at-most-k/description/">3578. 统计极差最大为 K 的分割方式数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long mod = (long) 1e9 + 7;
        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];
        // 使用有序集合维护区间最小最大值
        TreeMap<Integer, Integer> cnt = new TreeMap<>();
        dp[0] = 1;
        prefix[0] = 1;
        for (int i = 0, j = 0; i < n; i++) {
            cnt.compute(nums[i], (key, val) -> val == null ? 1 : (val + 1));
            // 滑动窗口，对于当前作为右端点，找窗口最小最大值不超过 k 的左端点
            while (j < i && cnt.lastKey() - cnt.firstKey() > k) {
                cnt.compute(nums[j], (key, val) -> val == null || val == 1 ? null : (val - 1));
                j++;
            }
            // dp[i+1] = dp[j] + dp[j+1] + ... + dp[i]
            dp[i + 1] = (prefix[i] - (j > 0 ? prefix[j - 1] : 0) + mod) % mod;
            prefix[i + 1] = (prefix[i] + dp[i + 1]) % mod;
        }
        return (int) dp[n];
    }
}