package leetcode.normal.j2643;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/row-with-maximum-ones/description/">2643. 一最多的行</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[] ans = new int[2];
        ans[0] = -1;
        for (int i = 0; i < rows; i++) {
            int cnt = 0;
            for (int j = 0; j < cols; j++) {
                cnt += mat[i][j];
            }
            if (ans[0] == -1 || cnt > ans[1]) {
                ans[0] = i;
                ans[1] = cnt;
            }
        }
        return ans;
    }
}