package leetcode.normal.j2923;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-champion-i/description/">2923. 找到冠军 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            boolean check = true;
            for (int j = 0; j < n && check; j++) {
                if (i != j && grid[i][j] == 0) {
                    check = false;
                    break;
                }
            }
            if (check) return i;
        }
        return 0;
    }
}