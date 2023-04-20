package leetcode.normal.j1187;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/make-array-strictly-increasing/">1187. 使数组严格递增</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        TreeSet<Integer> tSet = new TreeSet<>();
        for (int num : arr2) {
            tSet.add(num);
        }
        int n = arr1.length, m = tSet.size();
        // dp[i][j] 表示为前 i 个数组替换了 j 个元素后的最最小值是什么，默认为正无穷
        int[][] dp = new int[n + 1][Math.min(n, m) + 1];
        for (int i = 0; i <= n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[0][0] = -1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, m); j++) {
                // 如果要保留当前元素，那么当前元素一定比前 i-1 个元素都要大
                // 如果当前元素大于序列的最后一个元素
                if (arr1[i - 1] > dp[i - 1][j]) {
                    dp[i][j] = arr1[i - 1];
                }
                if (j > 0 && dp[i - 1][j - 1] != Integer.MAX_VALUE) {
                    // 如果当前元素不保留，要从 arr2 找一个元素来替换
                    // 需要找到严格大于 dp[i-1][j-1] 的最大值
                    Integer higher = tSet.higher(dp[i - 1][j - 1]);
                    if (higher != null) {
                        dp[i][j] = Math.min(dp[i][j], higher);
                    }
                }
                if (i == n && dp[i][j] != Integer.MAX_VALUE) return j;
            }
        }
        return -1;
    }
}