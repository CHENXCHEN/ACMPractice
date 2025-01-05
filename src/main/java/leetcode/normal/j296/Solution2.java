package leetcode.normal.j296;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/best-meeting-point/description/">296. 最佳的碰头地点</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int minTotalDistance(int[][] grid) {
        // 最小一乘法，我们找到所有 friends 的下标 (x,y)
        // 要找到一个值 x'，使得 sum(x_i - x') 值最小，这个值是 x_i 的中位数
        // 同理 y' 也是 y_i 的中位数
        int rows = grid.length, cols = grid[0].length, friendCnt = 0;
        int[] countX = new int[rows], countY = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    friendCnt++;
                    countX[i]++;
                    countY[j]++;
                }
            }
        }
        // 找到 x
        int x = -1, y = -1, tmpCnt = 0;
        int midVal = (friendCnt + 1) / 2;
        while (tmpCnt < midVal) {
            x++;
            tmpCnt += countX[x];
        }
        // 找到 y
        tmpCnt = 0;
        while (tmpCnt < midVal) {
            y++;
            tmpCnt += countY[y];
        }
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            ans += Math.abs(countX[i] * (i - x));
        }
        for (int j = 0; j < cols; j++) {
            ans += Math.abs(countY[j] * (j - y));
        }
        return ans;
    }
}