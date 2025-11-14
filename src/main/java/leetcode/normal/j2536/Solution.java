package leetcode.normal.j2536;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/increment-submatrices-by-one/description/">2536. 子矩阵元素加 1</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n + 1][n + 1];
        for (int[] query : queries) {
            int r1 = query[0], c1 = query[1], r2 = query[2], c2 = query[3];
            diff[r1][c1]++;
            diff[r1][c2 + 1]--;
            diff[r2 + 1][c1]--;
            diff[r2 + 1][c2 + 1]++;
        }
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int left = j > 0 ? diff[i][j - 1] : 0;
                int top = i > 0 ? diff[i - 1][j] : 0;
                int topLeft = i > 0 && j > 0 ? diff[i - 1][j - 1] : 0;
                diff[i][j] += left + top - topLeft;
                ans[i][j] = diff[i][j];
            }
        }
        return ans;
    }
}