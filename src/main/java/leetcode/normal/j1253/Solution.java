package leetcode.normal.j1253;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/reconstruct-a-2-row-binary-matrix/">1253. 重构 2 行二进制矩阵</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        int[][] ans = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (colsum[i] == 2) {
                upper--;
                lower--;
                ans[i][0] = 1;
                ans[i][1] = 1;
            }
        }
        if (upper < 0 || lower < 0) return new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (colsum[i] == 1) {
                if (upper > 0) {
                    --upper;
                    ans[i][0] = 1;
                } else if (lower > 0) {
                    --lower;
                    ans[i][1] = 1;
                } else {
                    return new ArrayList<>();
                }
            }
        }
        if (upper == 0 && lower == 0) {
            ArrayList<Integer> row0 = new ArrayList<>(), row1 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                row0.add(ans[i][0]);
                row1.add(ans[i][1]);
            }
            ArrayList<List<Integer>> res = new ArrayList<>();
            res.add(row0);
            res.add(row1);
            return res;
        }
        return new ArrayList<>();
    }
}