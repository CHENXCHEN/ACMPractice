package leetcode.normal.j1252;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix/">1252. 奇数值单元格的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] rowCnt = new int[m], colCnt = new int[n];
        for (int[] indic : indices) {
            rowCnt[indic[0]]++;
            colCnt[indic[1]]++;
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans += (rowCnt[i] + colCnt[j]) & 1;
            }
        }
        return ans;
    }
}