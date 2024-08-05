package leetcode.normal.j600;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/non-negative-integers-without-consecutive-ones/description/">600. 不含连续1的非负整数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findIntegers(int n) {
        int[] dp = new int[31];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < 31; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int pre = 0, res = 0;
        for (int i = 29; i >= 0; i--) {
            // 如果当前位数为 1，那么加上第 i + 1 位为 0 的非连续 1 的数字个数
            // 其实等于第 i 位为 0，和第 i-1 位为 0 开始的数字个数
            if (((n >> i) & 1) == 1) {
                res += dp[i + 1];
                if (pre == 1) break;
                pre = 1;
            } else pre = 0;
            if (i == 0) ++res;
        }
        return res;
    }
}