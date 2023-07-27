package leetcode.normal.j2500;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/delete-greatest-value-in-each-row/">2500. 删除每行中的最大值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int ans = 0, rows = grid.length, cols = grid[0].length;
        for (int[] arr : grid) {
            Arrays.sort(arr);
        }
        for (int i = 0; i < cols; i++) {
            int mx = grid[0][i];
            for (int j = 1; j < rows; j++) {
                mx = Math.max(mx, grid[j][i]);
            }
            ans += mx;
        }
        return ans;
    }
}