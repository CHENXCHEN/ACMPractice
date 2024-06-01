package leetcode.normal.j2965;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-missing-and-repeated-values/description/">2965. 找出缺失和重复的数字</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] cnt = new int[n * n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ++cnt[grid[i][j]];
            }
        }
        int[] ans = new int[2];
        int tot = n * n;
        for (int i = 1; i <= tot; i++) {
            if (cnt[i] == 2) {
                ans[0] = i;
            } else if (cnt[i] == 0) {
                ans[1] = i;
            }
        }
        return ans;
    }
}