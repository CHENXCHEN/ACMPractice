package leetcode.normal.j3000;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-area-of-longest-diagonal-rectangle/description/">3000. 对角线最长的矩形的面积</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonal = 0, ans = 0;
        for (int[] dimension : dimensions) {
            int curDiagonal = dimension[0] * dimension[0] + dimension[1] * dimension[1];
            if (curDiagonal > maxDiagonal) {
                maxDiagonal = curDiagonal;
                ans = dimension[0] * dimension[1];
            } else if (curDiagonal == maxDiagonal) {
                ans = Math.max(ans, dimension[0] * dimension[1]);
            }
        }
        return ans;
    }
}