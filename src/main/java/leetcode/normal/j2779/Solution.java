package leetcode.normal.j2779;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-beauty-of-an-array-after-applying-operation/description/">2779. 数组的最大美丽值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 0, ans = 1, n = nums.length;
        while (left < n) {
            int maxRight = nums[left] + k;
            while (right < n && (nums[right] - k <= maxRight)) {
                ++right;
            }
            ans = Math.max(ans, right - left);
            ++left;
        }
        return ans;
    }
}