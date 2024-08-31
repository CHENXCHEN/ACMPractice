package leetcode.normal.j3127;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/make-a-square-with-the-same-color/description/">3127. 构造相同颜色的正方形</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean canMakeSquare(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                int[] color = {getNumber(grid[i - 1][j - 1]), getNumber(grid[i - 1][j]), getNumber(grid[i][j - 1]), getNumber(grid[i][j])};
                long cnt0 = Arrays.stream(color).filter(x -> x == 0).count();
                long cnt1 = Arrays.stream(color).filter(x -> x == 1).count();
                if (cnt0 == 1 || cnt1 == 1 || cnt0 == 4 || cnt1 == 4) return true;
            }
        }
        return false;
    }

    int getNumber(char ch) {
        return ch == 'W' ? 0 : 1;
    }
}