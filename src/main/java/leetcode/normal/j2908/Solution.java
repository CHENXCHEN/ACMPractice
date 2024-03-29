package leetcode.normal.j2908;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-sum-of-mountain-triplets-i/description/">2908. 元素和最小的山形三元组 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int[] leftMin = new int[n], rightMin = new int[n];
        leftMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }
        rightMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }
        int ans = -1;
        for (int i = 1; i < n - 1; i++) {
            if (leftMin[i - 1] < nums[i] && nums[i] > rightMin[i + 1]) {
                int res = leftMin[i - 1] + nums[i] + rightMin[i + 1];
                if (ans == -1 || res < ans) {
                    ans = res;
                }
            }
        }
        return ans;
    }
}