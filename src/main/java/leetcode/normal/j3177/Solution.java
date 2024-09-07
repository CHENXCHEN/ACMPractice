package leetcode.normal.j3177;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-maximum-length-of-a-good-subsequence-ii/description/">3177. 求出最长好子序列 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximumLength(int[] nums, int k) {
        // dp[x][j] 表示以 x 结尾的子序列，有 j 个相邻不相等的最大长度是多少
        // zd[j] 表示有 j - 1 个相邻不相等，且末尾元素与 x 不相等的子序列最大长度是多少
        Map<Integer, int[]> dp = new HashMap<Integer, int[]>();
        int[] zd = new int[k + 2];
        for (int x : nums) {
            int[] cur = dp.computeIfAbsent(x, i -> new int[k + 1]);
            for (int j = k; j >= 0; j--) {
                // 如果 x = num，有 j 对不相等的最大长度为 cur[j] + 1
                // 如果 x != num，有 j-1 对相等的最大长度为 zd[j] + 1
                cur[j] = Math.max(cur[j], zd[j]) + 1;
                // 使用 cur[j] 来更新 zd[j+1]，不会影响结果
                // 当 x = num 时候，dp[x][j] > dp[x][j-1] 是一定的
                zd[j + 1] = Math.max(zd[j + 1], cur[j]);
            }
        }
        return zd[k + 1];
    }
}