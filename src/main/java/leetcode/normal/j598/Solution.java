package leetcode.normal.j598;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/range-addition-ii/
 * 598. 范围求和 II
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) return m * n;
        int minX = ops[0][0], minY = ops[0][1];
        for (int[] op : ops) {
            minX = Math.min(minX, op[0]);
            minY = Math.min(minY, op[1]);
        }
        return minX * minY;
    }
}
