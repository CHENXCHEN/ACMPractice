package leetcode.normal.j1798;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-number-of-consecutive-values-you-can-make/">1798. 你能构造出连续值的最大数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int ans = 1;
        // 如果目前可以构造出 [0, ans) 的连续整数，当取一个数为 y，当 y >= ans 时候，可以构造出 [0, ans + y)
        for (int coin : coins) {
            if (coin > ans) break;
            ans += coin;
        }
        return ans;
    }
}