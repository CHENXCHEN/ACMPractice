package leetcode.normal.j2209;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-white-tiles-after-covering-with-carpets/description/">2209. 用地毯覆盖后的最少白色砖块</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int n = floor.length();
        // dp[i][j] 表示第 i 快地毯，盖在 [i-carpetLen+1,i] 后，[0...j] 的最小白色砖块数
        // dp[0][j] = sum(floor[0..j] == 1)
        // dp[i][j] = dp[i][j-1] + floor[j] == 1
        // dp[i][j] = min(dp[i][j], dp[i-1][j] - (dp[i-1][j] - dp[i-1][j-carpetLen])) = min(dp[i][j], dp[i-1][j-carpetLen])
        int[][] dp = new int[2][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] + floor.charAt(i - 1) - '0';
        }
        Arrays.fill(dp[1], 0x3f3f3f3f);
        dp[1][0] = 0;
        int cur = 0;
        for (int i = 0; i < numCarpets; i++) {
            cur ^= 1;
            for (int j = 1; j <= n; j++) {
                dp[cur][j] = dp[cur][j - 1] + (floor.charAt(j - 1) - '0');
                dp[cur][j] = Math.min(dp[cur][j], dp[cur ^ 1][Math.max(0, j - carpetLen)]);
            }
        }
        return dp[cur][n];
    }
}