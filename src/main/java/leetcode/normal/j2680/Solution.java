package leetcode.normal.j2680;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-or/description/"></a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        long[] suffix = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = nums[i] | suffix[i + 1];
        }
        long pre = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            long cur = suffix[i + 1] | pre | ((long) nums[i] << k);
            pre |= nums[i];
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}