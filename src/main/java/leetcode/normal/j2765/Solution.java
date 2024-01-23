package leetcode.normal.j2765;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/longest-alternating-subarray/description/">2765. 最长交替子数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int alternatingSubarray(int[] nums) {
        int ans = -1, i = 0;
        while (i + 1 < nums.length) {
            if (nums[i + 1] - nums[i] == 1) {
                int a = nums[i], b = nums[i + 1], res = 0;
                while (i + 1 < nums.length && nums[i] == a && nums[i + 1] == b) {
                    res += 2;
                    i += 2;
                }
                if (i < nums.length && nums[i] == a) ++res;
                --i;
                ans = Math.max(ans, res);
            } else i++;
        }
        return ans;
    }
}