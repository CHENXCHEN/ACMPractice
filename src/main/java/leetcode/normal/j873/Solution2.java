package leetcode.normal.j873;

import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/">873. 最长的斐波那契子序列的长度</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int lenLongestFibSubseq(int[] arr) {
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) tMap.put(arr[i], i);
        // dp[i][j] 为：斐波那契末尾为 arr[i] 以及 arr[j] 时，斐波那契的最大长度
        // dp[i][j] = Math.max(dp[k][i] + 1, 3) (k < i < j), (arr[k] + arr[i] = arr[j])
        // arr[i] < arr[j]
        // arr[k] + arr[i] < arr[j] (arr[k] != arr[i] && arr[k] < arr[i])
        int[][] dp = new int[arr.length][arr.length];
        int ans = 0;
        for (int j = 2; j < arr.length; j++) {
            for (int i = j - 1; i > 0 && (arr[i] << 1) > arr[j]; i--) {
                Integer k = tMap.get(arr[j] - arr[i]);
                if (k != null) {
                    dp[i][j] = Math.max(dp[k][i] + 1, 3);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}