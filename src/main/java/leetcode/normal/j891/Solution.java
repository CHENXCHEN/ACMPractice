package leetcode.normal.j891;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/sum-of-subsequence-widths/description/">891. 子序列宽度之和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int sumSubseqWidths(int[] nums) {
        final int MOD = 1000000007;
        // 排序不影响结果
        Arrays.sort(nums);
        long res = 0;
        long x = nums[0], y = 2;
        // 数学公式
        for (int j = 1; j < nums.length; j++) {
            res = (res + nums[j] * (y - 1) - x) % MOD;
            x = (x * 2 + nums[j]) % MOD;
            y = y * 2 % MOD;
        }
        return (int) ((res + MOD) % MOD);
    }
}