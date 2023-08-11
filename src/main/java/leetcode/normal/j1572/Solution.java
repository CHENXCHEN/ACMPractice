package leetcode.normal.j1572;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/matrix-diagonal-sum/">1572. 矩阵对角线元素的和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int diagonalSum(int[][] mat) {
        int ans = 0, n = mat.length;
        for (int i = 0, r = n - 1; i < n; i++, r--) {
            ans += mat[i][i];
            if (r != i) ans += mat[i][r];
        }
        return ans;
    }
}