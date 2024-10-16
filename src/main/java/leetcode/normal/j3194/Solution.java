package leetcode.normal.j3194;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-average-of-smallest-and-largest-elements/description/">3194. 最小元素和最大元素的最小平均值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double ans = Double.MAX_VALUE;
        int n = nums.length, half = nums.length / 2;
        for (int i = 0; i < half; i++) {
            ans = Math.min(ans, (nums[i] + nums[n - i - 1]) / 2.0);
        }
        return ans;
    }
}