package leetcode.normal.j2679;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/sum-in-a-matrix/">2679. 矩阵中的和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int matrixSum(int[][] nums) {
        int rows = nums.length, cols = nums[0].length;
        // 矩阵中的每一行都排序，取每一列的最大值加起来就可以了
        for (int i = 0; i < rows; i++) {
            Arrays.sort(nums[i]);
        }
        int ans = 0;
        for (int j = 0; j < cols; j++) {
            int mx = nums[0][j];
            for (int i = 1; i < rows; i++) {
                mx = Math.max(mx, nums[i][j]);
            }
            ans += mx;
        }
        return ans;
    }
}