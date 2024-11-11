package leetcode.normal.j1547;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-cost-to-cut-a-stick/description/">1547. 切棍子的最小成本</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    // 令 dp[i][j] 表示 [cuts[i],cuts[j]] 这个位置要切的最小成本是多少
    //      dp[i][j] = min(dp[i][k-1] + dp[k+1][j]) + len, k 满足 cuts[i] < cuts[k] < cuts[j], len 满足为当前父区间长度
    //      dp[i][j] = 0, 没有 k 满足 cuts[i] < cuts[k] < cuts[j]
    int[][] dp;
    int cutLen;
    int[] newCuts;

    public int minCost(int n, int[] cuts) {
        cutLen = cuts.length;
        newCuts = new int[cutLen + 2];
        Arrays.sort(cuts);
        for (int i = 0; i < cutLen; i++) {
            newCuts[i + 1] = cuts[i];
        }
        newCuts[cutLen + 1] = n;
        dp = new int[cutLen + 1][cutLen + 1];
        for (int i = 0; i <= cutLen; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(1, cutLen);
    }

    int dfs(int cutLeft, int cutRight) {
        if (cutLeft > cutRight) return 0;
        if (dp[cutLeft][cutRight] != -1) return dp[cutLeft][cutRight];
        int res = Integer.MAX_VALUE;
        for (int i = cutLeft; i <= cutRight; i++) {
            res = Math.min(res, dfs(cutLeft, i - 1) + dfs(i + 1, cutRight));
        }
        dp[cutLeft][cutRight] = res + newCuts[cutRight + 1] - newCuts[cutLeft - 1];
        return dp[cutLeft][cutRight];
    }
}