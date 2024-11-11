package leetcode.normal.j1547;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-cost-to-cut-a-stick/description/">1547. 切棍子的最小成本</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    // 令 dp[i][j] 表示 [cuts[i],cuts[j]] 这个位置要切的最小成本是多少
    //      dp[i][j] = min(dp[i][k-1] + dp[k+1][j]) + len, k 满足 cuts[i] < cuts[k] < cuts[j], len 满足为当前父区间长度
    //      dp[i][j] = 0, 没有 k 满足 cuts[i] < cuts[k] < cuts[j]
    int[][] dp;
    int cutLen;
    int[] cuts;

    public int minCost(int n, int[] cuts) {
        this.cuts = cuts;
        cutLen = cuts.length;
        dp = new int[cutLen + 1][cutLen + 1];
        for (int i = 0; i <= cutLen; i++) {
            Arrays.fill(dp[i], -1);
        }
        Arrays.sort(cuts);
        return dfs(0, n, 0, cutLen - 1);
    }

    int dfs(int start, int end, int cutLeft, int cutRight) {
        if (cutLeft > cutRight) return 0;
        if (dp[cutLeft][cutRight] != -1) return dp[cutLeft][cutRight];
        int res = Integer.MAX_VALUE;
        for (int i = cutLeft; i <= cutRight; i++) {
            if (cuts[i] > start && cuts[i] < end) {
                res = Math.min(res, dfs(start, cuts[i], cutLeft, i - 1) + dfs(cuts[i], end, i + 1, cutRight));
            }
        }
        if (res == Integer.MAX_VALUE) {
            dp[cutLeft][cutRight] = 0;
        } else {
            dp[cutLeft][cutRight] = res + end - start;
        }
        return dp[cutLeft][cutRight];
    }
}