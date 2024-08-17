package leetcode.normal.j3117;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-sum-of-values-by-dividing-array/description/">3117. 划分数组得到最小的值之和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] nums;
    int[] andValues;
    // dp[i][j] 表示，从 nums[i] 开始，从 andValues[j] 开始匹配的最小值和
    Map<Integer, Integer>[] dp;
    int INF = (1 << 20) - 1;
    int n, m;

    public int minimumValueSum(int[] nums, int[] andValues) {
        this.nums = nums;
        this.andValues = andValues;
        n = nums.length;
        m = andValues.length;
        dp = new HashMap[n * m];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new HashMap<>();
        }
        int ans = dfs(0, 0, INF);
        return ans != INF ? ans : -1;
    }

    int dfs(int idx, int andIdx, int cur) {
        if (andIdx == m && idx == n) {
            return 0;
        }
        if (andIdx >= m || idx >= n) {
            return INF;
        }
        int key = idx * m + andIdx;
        Integer now = dp[key].get(cur);
        if (now != null) return now;

        cur &= nums[idx];
        if ((cur & andValues[andIdx]) < andValues[andIdx]) return INF;
        int res = dfs(idx + 1, andIdx, cur);
        if (cur == andValues[andIdx]) {
            res = Math.min(res, dfs(idx + 1, andIdx + 1, INF) + nums[idx]);
        }
        dp[key].put(cur, res);
        return res;
    }
}