package leetcode.normal.j3117;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-sum-of-values-by-dividing-array/description/">3117. 划分数组得到最小的值之和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {

    public int minimumValueSum(int[] nums, int[] andValues) {
        int n = nums.length, m = andValues.length;
        // dp[i][j][k] => 前 i 个元素，划分为前 j 组，且最后 1 最的 and 为 k 的最小和是多少
        Map<Integer, Integer> dp[][] = new HashMap[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = new HashMap<>();
            }
        }
        dp[0][0].put(nums[0], 0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < Math.min(m, i + 1); j++) {
                // 如果已经匹配上一个 andValue，那么可以开始新的
                if (j > 0 && dp[i - 1][j - 1].containsKey(andValues[j - 1])) {
                    dp[i][j].put(nums[i], dp[i - 1][j - 1].get(andValues[j - 1]) + nums[i - 1]);
                }
                // 继续前一段
                for (Map.Entry<Integer, Integer> entry : dp[i - 1][j].entrySet()) {
                    int last = entry.getKey();
                    int cur = last & nums[i];
                    int minValue = Math.min(dp[i][j].getOrDefault(cur, Integer.MAX_VALUE), entry.getValue());
                    dp[i][j].put(cur, minValue);
                }
            }
        }
        int ans = dp[n - 1][m - 1].getOrDefault(andValues[m - 1], Integer.MAX_VALUE);
        return ans != Integer.MAX_VALUE ? ans + nums[n - 1] : -1;
    }
}