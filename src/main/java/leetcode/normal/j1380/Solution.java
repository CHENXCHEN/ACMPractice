package leetcode.normal.j1380;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix/
 * 1380. 矩阵中的幸运数
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[] rowsMin = new int[rows], colsMax = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int item = matrix[i][j];
                if (j == 0 || rowsMin[i] > item) rowsMin[i] = item;
                if (i == 0 || colsMax[j] < item) colsMax[j] = item;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int item = matrix[i][j];
                if (rowsMin[i] == item && colsMax[j] == item) ans.add(item);
            }
        }
        return ans;
    }
}