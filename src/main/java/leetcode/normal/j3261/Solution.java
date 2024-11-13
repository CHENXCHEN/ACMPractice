package leetcode.normal.j3261;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-substrings-that-satisfy-k-constraint-ii/description/">3261. 统计满足 K 约束的子字符串数量 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long[] countKConstraintSubstrings(String s, int k, int[][] queries) {
        int n = s.length();
        // right[i] 表示 [i, right[i]) 内的任意长度字符串都符合满足 k 约束
        // preSum[i] 长度为 [1,...,i] 的满足 k 约束的字符串的数量和
        int[] cnt = new int[2], right = new int[n], preSum = new int[n + 1];
        Arrays.fill(right, n);
        for (int i = 0, j = 0; i < n; i++) {
            ++cnt[s.charAt(i) - '0'];
            while (cnt[0] > k && cnt[1] > k) {
                --cnt[s.charAt(j) - '0'];
                right[j] = i;
                ++j;
            }
            preSum[i + 1] = preSum[i] + i - j + 1;
        }
        int m = queries.length;
        long[] ans = new long[m];
        for (int i = 0; i < m; i++) {
            int l = queries[i][0], r = queries[i][1];
            int x = Math.min(right[l], r + 1);
            // [l, r] 满足 k 约束的字符串总数为：[l,right[l]) 满足k约束的字符串数量 + [right[l], r] 满足 k 约束的字符串数量
            long part1 = (long) (x - l + 1) * (x - l) / 2;
            long part2 = preSum[r + 1] - preSum[x];
            ans[i] = part1 + part2;
        }
        return ans;
    }
}