package leetcode.normal.j3095;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/shortest-subarray-with-or-at-least-k-i/description/">3095. 或值至少 K 的最短子数组 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int ans = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            for (int j = i; j < nums.length; j++) {
                cur |= nums[j];
                if (cur >= k) {
                    ans = Math.min(ans, j - i + 1);
                }
            }
        }
        return ans == nums.length + 1 ? -1 : ans;
    }
}