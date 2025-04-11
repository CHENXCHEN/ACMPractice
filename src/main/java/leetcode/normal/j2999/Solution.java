package leetcode.normal.j2999;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-the-number-of-powerful-integers/description/">2999. 统计强大整数的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    String low, high, s;
    int preLen, n, limit;
    // memo[i] 表示第 i 位填入之后合法的数量
    long[] memo;

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        this.low = String.valueOf(start);
        this.high = String.valueOf(finish);
        this.s = s;
        this.limit = limit;
        this.n = high.length();
        this.low = String.format("%" + n + "s", low).replace(' ', '0');
        this.preLen = n - s.length();
        this.memo = new long[n];
        Arrays.fill(memo, -1);
        return dfs(0, true, true);
    }

    long dfs(int i, boolean limitLow, boolean limitHigh) {
        // 走到末尾了，就是合法的
        if (i == low.length()) {
            return 1;
        }
        // 如果不是上限且不是下限，那么结果可以缓存
        if (!limitLow && !limitHigh && memo[i] != -1) {
            return memo[i];
        }
        int lo = limitLow ? low.charAt(i) - '0' : 0;
        int hi = limitHigh ? high.charAt(i) - '0' : 9;
        long res = 0;
        if (i < preLen) {
            // 在达到后缀之前，每一位都要枚举
            for (int j = lo; j <= Math.min(hi, limit); j++) {
                res += dfs(i + 1, limitLow && j == lo, limitHigh && j == hi);
            }
        } else {
            // 达到后缀之后，只能选择后缀的位数枚举
            int x = s.charAt(i - preLen) - '0';
            if (lo <= x && x <= Math.min(hi, limit)) {
                res += dfs(i + 1, limitLow && x == lo, limitHigh && x == hi);
            }
        }
        if (!limitLow && !limitHigh) {
            memo[i] = res;
        }
        return res;
    }
}