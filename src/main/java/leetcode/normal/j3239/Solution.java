package leetcode.normal.j3239;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-flips-to-make-binary-grid-palindromic-i/description/">3239. 最少翻转次数使二进制矩阵回文 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minFlips(int[][] grid) {
        int ans = Integer.MAX_VALUE;
        int rows = grid.length, cols = grid[0].length;
        // 如果所有行都是回文
        int res = 0;
        for (int i = 0; i < rows; i++) {
            int l = 0, r = cols - 1;
            while (l < r) {
                if (grid[i][l] != grid[i][r]) ++res;
                ++l;
                --r;
            }
        }
        ans = Math.min(ans, res);
        res = 0;
        // 如果所有列都是回文
        for (int j = 0; j < cols; j++) {
            int l = 0, r = rows - 1;
            while (l < r) {
                if (grid[l][j] != grid[r][j]) ++res;
                l++;
                r--;
            }
        }
        ans = Math.min(ans, res);
        return ans;
    }
}