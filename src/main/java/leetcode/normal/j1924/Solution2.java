package leetcode.normal.j1924;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/chuan-di-xin-xi/
 * LCP 07. 传递信息
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution2 {
    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 2][n + 2];
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = 0;
        for (int step = 1; step <= k; step++) {
            for (int[] rel : relation) {
                int from = rel[0];
                int to = rel[1];
                dp[step][to] += dp[step - 1][from];
            }
        }
        return dp[k][n - 1];
    }
}
