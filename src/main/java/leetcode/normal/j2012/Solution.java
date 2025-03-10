package leetcode.normal.j2012;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/sum-of-beauty-in-the-array/description/">2012. 数组美丽值求和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int sumOfBeauties(int[] nums) {
        int ans = 0, n = nums.length;
        int[] rightMin = new int[n];
        rightMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }
        int leftMax = nums[0];
        for (int i = 1; i < n - 1; i++) {
            if (leftMax < nums[i] && nums[i] < rightMin[i + 1]) {
                ans += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                ans += 1;
            }
            leftMax = Math.max(leftMax, nums[i]);
        }
        return ans;
    }
}