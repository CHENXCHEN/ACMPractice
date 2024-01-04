package leetcode.normal.j2397;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-rows-covered-by-columns/description/">2397. 被列覆盖的最多行数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximumRows(int[][] matrix, int numSelect) {
        int rows = matrix.length, cols = matrix[0].length;
        int[] rowMark = new int[rows];
        for (int i = 0; i < rows; i++) {
            int mark = 0;
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) mark |= 1 << j;
            }
            rowMark[i] = mark;
        }
        int tot = 1 << cols, ans = 0;
        for (int i = 0; i < tot; i++) {
            if (Integer.bitCount(i) == numSelect) {
                int cnt = 0;
                for (int r = 0; r < rows; r++) {
                    if ((rowMark[r] & i) == rowMark[r]) cnt++;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}