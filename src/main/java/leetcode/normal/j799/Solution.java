package leetcode.normal.j799;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/champagne-tower/description/">799. 香槟塔</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] row = {poured};
        for (int i = 1; i <= query_row; i++) {
            double[] next = new double[i + 1];
            for (int j = 0; j < i; j++) {
                double cur = row[j];
                if (cur > 1) {
                    next[j] += (cur - 1) / 2;
                    next[j + 1] += (cur - 1) / 2;
                }
            }
            row = next;
        }
        return Math.min(row[query_glass], 1.0);
    }
}