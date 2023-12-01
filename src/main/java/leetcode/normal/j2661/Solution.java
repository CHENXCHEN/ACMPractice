package leetcode.normal.j2661;

import javafx.util.Pair;

import java.util.HashMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/first-completely-painted-row-or-column/description/">2661. 找出叠涂元素</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer, Pair<Integer, Integer>> mp = new HashMap<>();
        int rows = mat.length, cols = mat[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mp.put(mat[i][j], new Pair<>(i, j));
            }
        }
        int[] cntRows = new int[rows], cntCols = new int[cols];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            Pair<Integer, Integer> to = mp.get(arr[i]);
            cntRows[to.getKey()]++;
            cntCols[to.getValue()]++;
            if (cntRows[to.getKey()] == cols || cntCols[to.getValue()] == rows) {
                ans = Math.min(ans, i);
            }
        }
        return ans;
    }
}