package leetcode.normal.j1498;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/">1498. 满足条件的子序列数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        long ans = 0, mod = (long) 1e9 + 7;
        long[] pre = new long[nums.length];
        pre[0] = 1;
        for (int i = 1; i < nums.length; i++) pre[i] = (pre[i - 1] << 1) % mod;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++) {
            if (nums[i] * 2 > target) break;
            while (j > i && nums[i] + nums[j] > target) --j;
            ans = (ans + pre[j - i]) % mod;
        }
        return (int) ans;
    }
}