package leetcode.normal.j3363;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-maximum-number-of-fruits-collected/description/">3363. 最多可收集的水果数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += fruits[i][i];
        }
        ans += solve(fruits);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = fruits[j][i];
                fruits[j][i] = fruits[i][j];
                fruits[i][j] = temp;
            }
        }
        ans += solve(fruits);
        return ans;
    }

    int solve(int[][] fruits) {
        // 从 [0, n-1] 开始走，走到 [n-2, n-1] 能拿到最大的值是多少
        int n = fruits.length;
        int[] prev = new int[n];
        int[] curr = new int[n];
        Arrays.fill(prev, Integer.MIN_VALUE);
        Arrays.fill(curr, Integer.MIN_VALUE);
        prev[n - 1] = fruits[0][n - 1];
        for (int i = 1; i < n - 1; i++) {
            // 当在第 i 行，合法的范围是右边三角形开始的，但是要大于 i + 1
            for (int j = Math.max(n - 1 - i, i + 1); j < n; j++) {
                int best = prev[j];
                if (j - 1 >= 0) best = Math.max(best, prev[j - 1]);
                if (j + 1 < n) best = Math.max(best, prev[j + 1]);
                curr[j] = best + fruits[i][j];
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[n - 1];
    }
}