package leetcode.normal.j3098;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-sum-of-subsequence-powers/description/">3098. 求出所有子序列的能量和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int sumOfPowers(int[] nums, int k) {
        int n = nums.length;
        int INF = Integer.MAX_VALUE;
        int MOD = 1000000007;
        // dp[i][p][v] -> 以 i 为结尾，长度为 p 的，能量为 v 的有多少个
        TreeMap<Integer, Integer>[][] dp = new TreeMap[n][k + 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= k; j++)
                dp[i][j] = new TreeMap<>();
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i][1].put(INF, 1);
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                for (int p = 2; p <= k; p++) {
                    for (Map.Entry<Integer, Integer> entry : dp[j][p - 1].entrySet()) {
                        int v = entry.getKey(), cnt = entry.getValue();
                        int curKey = Math.min(diff, v);
                        dp[i][p].compute(curKey, (kk, vv) -> ((vv == null ? 0 : vv) + cnt) % MOD);
                    }
                }
            }
            for (Map.Entry<Integer, Integer> entry : dp[i][k].entrySet()) {
                int v = entry.getKey(), cnt = entry.getValue();
                ans = (int) (ans + (long) v * cnt % MOD) % MOD;
            }
        }
        return ans;
    }
}