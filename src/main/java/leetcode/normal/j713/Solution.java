package leetcode.normal.j713;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/subarray-product-less-than-k/
 * 713. 乘积小于 K 的子数组
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int lPos = 0, rPos = -1, tmp = 1;
        int ans = 0;
        while (lPos < nums.length) {
            if (rPos <= lPos) {
                rPos = lPos;
                tmp = 1;
            }
            while (rPos < nums.length && tmp * nums[rPos] < k) {
                tmp *= nums[rPos];
                rPos++;
            }
            if (rPos >= lPos && nums[lPos] < k) {
                ans += rPos - lPos;
                tmp /= nums[lPos];
            }
            lPos++;
        }
        return ans;
    }
}