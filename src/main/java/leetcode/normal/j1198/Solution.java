package leetcode.normal.j1198;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-smallest-common-element-in-all-rows/description/">1198. 找出所有行中最小公共元素</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int smallestCommonElement(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int ans = -1;
        for (int j = 0; j < cols; j++) {
            boolean check = true;
            for (int i = 1; i < rows && check; i++) {
                int idx = Arrays.binarySearch(mat[i], mat[0][j]);
                check = idx >= 0;
            }
            if (check) {
                ans = mat[0][j];
                break;
            }
        }
        return ans;
    }
}