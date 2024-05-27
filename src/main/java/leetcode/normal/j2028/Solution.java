package leetcode.normal.j2028;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-missing-observations/description/">2028. 找出缺失的观测数据</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length, len = m + n, sum = len * mean, left = n;
        sum -= Arrays.stream(rolls).sum();
        if (left <= sum && sum <= 6 * left) {
            int[] ans = new int[n];
            sum -= left;
            for (int i = 0; i < n; i++) {
                int tmp = Math.min(5, sum);
                ans[i] = 1 + tmp;
                sum -= tmp;
            }
            return ans;
        } else return new int[0];
    }
}