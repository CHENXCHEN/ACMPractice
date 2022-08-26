package leetcode.normal.j1464;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/">1464. 数组中两元素的最大乘积</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxProduct(int[] nums) {
        int[] maxNum = new int[]{nums[0], nums[1]};
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > maxNum[0]) {
                if (maxNum[0] > maxNum[1]) maxNum[1] = maxNum[0];
                maxNum[0] = nums[i];
            } else if (nums[i] > maxNum[1]) {
                if (maxNum[1] > maxNum[0]) maxNum[0] = maxNum[1];
                maxNum[1] = nums[i];
            }
        }
        return (maxNum[0] - 1) * (maxNum[1] - 1);
    }
}