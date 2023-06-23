package leetcode.normal.j1595;

import java.util.Arrays;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-cost-to-connect-two-groups-of-points/">1595. 连通两组点的最小成本</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int connectTwoGroups(List<List<Integer>> cost) {
        int size1 = cost.size(), size2 = cost.get(0).size(), m = 1 << size2;
        // dp[i][j] 表示为当前轮的前第 (0,...,i-1) 元素跟第二组的集合 s 的最小代价是多少
        int[][] dp = new int[size1 + 1][m];
        for (int i = 0; i <= size1; i++) Arrays.fill(dp[i], Integer.MAX_VALUE >> 1);
        dp[0][0] = 0;
        for (int i = 1; i <= size1; i++) {
            // 枚举第二组的集合的所有情况
            for (int s = 0; s < m; s++) {
                // 枚举第二组的所有位置
                for (int k = 0; k < size2; k++) {
                    if ((s & (1 << k)) == 0) {
                        continue;
                    }
                    // 如果第二组的第 k 个元素要跟第 i - 1 个元素进行相连
                    // 第二组 k 没有选择的情况下的代价加上 i-1 -> k 的代价
                    dp[i][s] = Math.min(dp[i][s], dp[i][s ^ (1 << k)] + cost.get(i - 1).get(k));
                    // 如果第二组的第 k 个元素要跟第 i - 1 个元素进行相连
                    // 第一组第 i-1 没有选择的代价加上 i-1 -> k 的代价
                    dp[i][s] = Math.min(dp[i][s], dp[i - 1][s] + cost.get(i - 1).get(k));
                    // 如果第二组的第 k 个元素要跟第 i - 1 个元素进行相连
                    // 第一组的第 i-1 没有选择并且第二组的 k 没有选择的代价 加上 i-1 -> k 的代价
                    dp[i][s] = Math.min(dp[i][s], dp[i - 1][s ^ (1 << k)] + cost.get(i - 1).get(k));
                }
            }
        }
        return dp[size1][m - 1];
    }
}