package leetcode.normal.j1877;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array/
 * 1877. 数组中最大数对和的最小值
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[nums.length - 1];
        int l = 1, r = nums.length - 2;
        while (l < r) {
            ans = Math.max(ans, nums[l] + nums[r]);
            ++l;
            --r;
        }
        return ans;
    }
}
