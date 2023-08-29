package leetcode.normal.j823;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/binary-trees-with-factors/">823. 带因子的二叉树</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        long mod = 1000000007, ans = 0;
        long[] dp = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int left = 0, right = i - 1; left <= right; left++) {
                // 找到使得乘积为 arr[i] 的对，双指针缩减区间
                while (left <= right && (long) arr[left] * arr[right] > arr[i]) {
                    right--;
                }
                if (left <= right && (long) arr[left] * arr[right] == arr[i]) {
                    // 如果是同一个值，那么 dp[left] * dp[right] 算出可以组成的种数
                    // 如果不是同一个，那么 dp[left] * dp[right] * 2 算出可以组成的种数，因为可以对换，所以要乘以 2
                    if (left == right) dp[i] = (dp[i] + dp[left] * dp[right]) % mod;
                    else dp[i] = (dp[i] + dp[left] * dp[right] * 2) % mod;
                }
            }
            ans = (ans + dp[i]) % mod;
        }
        return (int)ans;
    }

}