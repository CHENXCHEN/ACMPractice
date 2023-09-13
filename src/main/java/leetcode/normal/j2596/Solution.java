package leetcode.normal.j2596;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-knight-tour-configuration/description/">2596. 检查骑士巡视方案</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) return false;
        int rows = grid.length, cols = grid[0].length;
        Integer[] pos = new Integer[rows * cols];
        for (int i = 0; i < pos.length; i++) pos[i] = i;
        Arrays.sort(pos, Comparator.comparingInt(x -> grid[x / cols][x % cols]));
        for (int i = 1; i < pos.length; i++) {
            if (!check(pos[i - 1] / cols, pos[i - 1] % cols, pos[i] / cols, pos[i] % cols)) {
                return false;
            }
        }
        return true;
    }

    boolean check(int x, int y, int x1, int y1) {
        return (Math.abs(x - x1) == 1 && Math.abs(y - y1) == 2) ||
                (Math.abs(y - y1) == 1 && Math.abs(x - x1) == 2);
    }
}