package leetcode.normal.j2713;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-of-integers/description/">2719. 统计整数数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] dp;
    int minSum, maxSum;
    int MOD = 1000000007;

    public int count(String num1, String num2, int min_sum, int max_sum) {
        this.minSum = min_sum;
        this.maxSum = max_sum;
        dp = new int[23][401];
        for (int i = 0; i < 23; i++) Arrays.fill(dp[i], -1);
        return (getCnt(num2) - getCnt(subOne(num1)) + MOD) % MOD;
    }

    String subOne(String s) {
        char[] arr = s.toCharArray();
        int i = arr.length - 1;
        while (arr[i] == '0') --i;
        --arr[i];
        ++i;
        while (i < arr.length) {
            arr[i] = '9';
            ++i;
        }
        return new String(arr);
    }

    int getCnt(String num) {
        String numReverse = new StringBuffer(num).reverse().toString();
        return dfs(numReverse, numReverse.length() - 1, 0, true);
    }

    int dfs(String num, int i, int digitSum, boolean limit) {
        // 如果数位相加大于上限，则不合法
        if (digitSum > maxSum) return 0;
        // 如果已经枚举完了，那么判断是否大于下限
        if (i == -1) return digitSum >= minSum ? 1 : 0;
        // 如果不是最大值，且已经有过记录值
        if (!limit && dp[i][digitSum] != -1) return dp[i][digitSum];
        int res = 0;
        int up = limit ? num.charAt(i) - '0' : 9;
        for (int x = 0; x <= up; x++) {
            res = (res + dfs(num, i - 1, digitSum + x, limit && x == up)) % MOD;
        }
        // 如果不是最大值，那么记录
        if (!limit) dp[i][digitSum] = res;
        return res;
    }
}