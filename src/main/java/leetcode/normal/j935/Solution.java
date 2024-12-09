package leetcode.normal.j935;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/knight-dialer/description/">935. 骑士拨号器</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] dirs = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};
    int MOD = (int) 1e9 + 7;

    public int knightDialer(int n) {
        // dp[step][x][y] 表示 (x,y) 出发走 step 步的走法数有多少
        // dp[step][x][y] = sum(dp[step-1][dx][dy])
        int[][][] dp = new int[n][4][3];
        for (int step = 0; step < n; step++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!isValid(i, j)) continue;
                    if (step == 0) dp[step][i][j] = 1;
                    else {
                        for (int[] dir : dirs) {
                            int x = i + dir[0], y = j + dir[1];
                            if (isValid(x, y)) {
                                dp[step][i][j] = (dp[step][i][j] + dp[step - 1][x][y]) % MOD;
                            }
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (isValid(i, j)) ans = (ans + dp[n - 1][i][j]) % MOD;
            }
        }
        return ans;
    }

    boolean isValid(int x, int y) {
        // (x,y) 在棋盘内并且不位于最后一行的 (3,0), (3, 2)
        return (x >= 0 && x < 4 && y >= 0 && y < 3) && !(x == 3 && (y == 0 || y == 2));
    }
}