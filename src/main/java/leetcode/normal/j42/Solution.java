package leetcode.normal.j42;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * 42. 接雨水
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] <= height[right]) {
                ans += leftMax - height[left];
                left ++;
            } else {
                ans += rightMax - height[right];
                right --;
            }
        }
        return ans;
    }
}
