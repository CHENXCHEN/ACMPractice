package leetcode.normal.j209;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/description/">209. 长度最小的子数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0, left = 0, s = 0; i < nums.length; i++) {
            s += nums[i];
            while (left < i && s - nums[left] >= target) {
                s -= nums[left];
                left++;
            }
            if (s >= target) ans = Math.min(ans, i - left + 1);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}