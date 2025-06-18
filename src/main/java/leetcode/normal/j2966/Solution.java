package leetcode.normal.j2966;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/divide-array-into-arrays-with-max-difference/description/">2966. 划分数组并满足最大差限制</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] ans = new int[n / 3][3];
        for (int i = 0, j = 0; i < n; i += 3, j++) {
            ans[j][0] = nums[i];
            ans[j][1] = nums[i + 1];
            ans[j][2] = nums[i + 2];
            if (ans[j][2] - ans[j][0] > k) return new int[][]{};
        }
        return ans;
    }
}