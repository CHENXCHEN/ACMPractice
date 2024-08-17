package leetcode.normal.j3117;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-sum-of-values-by-dividing-array/description/">3117. 划分数组得到最小的值之和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution3 {

    public int minimumValueSum(int[] nums, int[] andValues) {
        int n = nums.length, m = andValues.length;
        // dp[i][j][k] => 前 i 个元素，划分为前 j 组，且最后 1 最的 and 为 k 的最小和是多少
        Map<Integer, Integer> dp[][] = new HashMap[2][m];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = new HashMap<>();
            }
        }
        dp[0][0].put(nums[0], 0);
        int pos = 1;
        for (int i = 1; i < n; i++) {
            int prePos = pos ^ 1;
            for (int j = 0; j < m; j++) {
                dp[pos][j] = new HashMap<>();
            }
            for (int j = 0; j < Math.min(m, i + 1); j++) {
                // 如果已经匹配上一个 andValue，那么可以开始新的
                if (j > 0 && dp[prePos][j - 1].containsKey(andValues[j - 1])) {
                    dp[pos][j].put(nums[i], dp[prePos][j - 1].get(andValues[j - 1]) + nums[i - 1]);
                }
                // 继续前一段
                for (Map.Entry<Integer, Integer> entry : dp[prePos][j].entrySet()) {
                    int last = entry.getKey();
                    int cur = last & nums[i];
                    // 这个值之后的值 and 必然不可能形成 andValue[j]
                    if ((cur & andValues[j]) < andValues[j]) continue;
                    int minValue = Math.min(dp[pos][j].getOrDefault(cur, Integer.MAX_VALUE), entry.getValue());
                    dp[pos][j].put(cur, minValue);
                }
            }
            pos ^= 1;
        }
        int ans = dp[pos ^ 1][m - 1].getOrDefault(andValues[m - 1], Integer.MAX_VALUE);
        return ans != Integer.MAX_VALUE ? ans + nums[n - 1] : -1;
    }
}