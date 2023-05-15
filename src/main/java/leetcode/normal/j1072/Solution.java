package leetcode.normal.j1072;

import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/flip-columns-for-maximum-number-of-equal-rows/">1072. 按列翻转得到最大值等行数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        TreeMap<String, Integer> tMap = new TreeMap<>();
        for (int i = 0; i < rows; i++) {
            StringBuilder sb = new StringBuilder();
            // 如果这一行想要变为本质相同的行，需要翻转哪一些列，记住要翻转的列
            // 统计要成为本质相同的行，都要翻转的相同列，最大的那个就是答案了
            for (int j = 0; j < cols; j++) {
                sb.append('0' + (matrix[i][j] ^ matrix[i][0]));
            }
            tMap.put(sb.toString(), tMap.getOrDefault(sb.toString(), 0) + 1);
        }
        return tMap.values().stream().mapToInt(v -> v).max().getAsInt();
    }
}