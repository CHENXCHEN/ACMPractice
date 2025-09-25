package leetcode.normal.j120;

import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/triangle/description/">120. 三角形最小路径和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int last = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            List<Integer> pre = triangle.get(i - 1);
            List<Integer> cur = triangle.get(i);
            int checkMin = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                int val = Math.min(getValue(pre, j - 1), getValue(pre, j)) + cur.get(j);
                cur.set(j, val);
                checkMin = Math.min(checkMin, val);
            }
            last = checkMin;
        }
        return last;
    }

    int getValue(List<Integer> row, int pos) {
        return pos >= 0 && pos < row.size() ? row.get(pos) : Integer.MAX_VALUE;
    }
}