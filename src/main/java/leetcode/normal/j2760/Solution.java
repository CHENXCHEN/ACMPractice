package leetcode.normal.j2760;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/longest-even-odd-subarray-with-threshold/description/">2760. 最长奇偶子数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length && nums[i] % 2 != 0) i++;
            int j = i;
            while (j < nums.length - 1 && nums[j] <= threshold && nums[j + 1] <= threshold && ((nums[j] ^ nums[j + 1]) & 1) == 1) {
                ++j;
            }
            if (i < nums.length && nums[i] % 2 == 0 && nums[i] <= threshold) {
                ans = Math.max(ans, j - i + 1);
            }
            i = j;
        }
        return ans;
    }
}