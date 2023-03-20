package leetcode.normal.j1012;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/numbers-with-repeated-digits/">1012. 至少有 1 位重复的数字</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] dp;

    public int numDupDigitsAtMostN(int n) {
        // 数位 DP，记忆化搜索，互斥原理
        String sn = String.valueOf(n);
        dp = new int[sn.length()][1 << 10];
        for (int i = 0; i < sn.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return n + 1 - f(0, sn, 0, true);
    }


    /**
     * 计算不包含重复的数字个数
     *
     * @param mask  标记元素 0~9 是否有被使用
     * @param sn    当前要判断的数字
     * @param i     当前是从左往右第几个数字
     * @param same  是否是边界
     * @return
     */
    int f(int mask, String sn, int i, boolean same) {
        if (i == sn.length()) return 1;
        if (!same && dp[i][mask] >= 0) return dp[i][mask];
        int res = 0, limit = same ? sn.charAt(i) - '0' : 9;
        for (int k = 0; k <= limit; k++) {
            // 如果某位数字被使用，那么跳过
            if (((mask >> k) & 1) == 1) continue;
            // 如果某位没被使用，那么加上它能形成的数字
            // 如果是前缀 0，那么 mask 应该也是 0，否则标记使用
            res += f(mask == 0 && k == 0 ? mask : mask | (1 << k)
                    , sn
                    , i + 1
                    , same && k == limit);
        }
        // 只有当不是边界的时候我们才记录，如果是边界的话，是被限制的，可能会导致遗漏
        if (!same) dp[i][mask] = res;
        return res;
    }
}