package leetcode.normal.j3459;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/length-of-longest-v-shaped-diagonal-segment/description/">3459. 最长 V 形对角线段的长度</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] dirs = {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}}, grid;
    int rows, cols;

    public int lenOfVDiagonal(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        // 枚举 1 的四个方向，每个方向再枚举前后两个方向即可
                        int cx = i, cy = j, last = -1, cnt = 0;
                        while (isValid(cx, cy) && grid[cx][cy] != last) {
                            ++cnt;
                            if (cnt >= 2 && (grid[cx][cy] != 0 && grid[cx][cy] != 2)) break;
                            if (cnt == 2 && grid[cx][cy] != 2) break;
                            if (cnt > 1) {
                                int nextCnt = longestPath(cx, cy, (k + 1) % 4);
                                ans = Math.max(ans, cnt + nextCnt - 1);
                            }
                            ans = Math.max(ans, cnt);
//                            System.out.println("cx=" + cx + ", cy=" + cy + ", cnt=" + cnt + ", ans=" + ans);
                            last = grid[cx][cy];
                            cx += dirs[k][0];
                            cy += dirs[k][1];
                        }
                    }
                }
            }
        }
        return ans;
    }

    boolean isValid(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    int longestPath(int x, int y, int k) {
        int cnt = 0, last = -1;
        while (isValid(x, y) && grid[x][y] != last) {
            if (grid[x][y] != 0 && grid[x][y] != 2) break;
            ++cnt;
            last = grid[x][y];
            x += dirs[k][0];
            y += dirs[k][1];
        }
        return cnt;
    }
}