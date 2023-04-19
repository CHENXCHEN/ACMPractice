package leetcode.normal.j1043;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/partition-array-for-maximum-sum/">1043. 分隔数组以得到最大和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < dp.length; i++) {
            int mVal = 0;
            // 枚举 [i - k + 1, i] 这个范围内的值如果替换为 arr[i] 的话，最大值会是多少
            for (int j = i; j >= 0 && j >= i - k + 1; j--) {
                mVal = Math.max(mVal, arr[j]);
                dp[i] = Math.max(dp[i], (j > 0 ? dp[j - 1] : 0) + mVal * (i - j + 1));
            }
        }
        return dp[arr.length - 1];
    }
}