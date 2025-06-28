package leetcode.normal.j2099;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-subsequence-of-length-k-with-the-largest-sum/description/">2099. 找到和最大的长度为 K 的子序列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> nums[a] - nums[b]);
        int[] res = new int[k], ans = new int[k];
        for (int i = n - k, j = 0; i < n; i++, j++) {
            res[j] = idx[i];
        }
        Arrays.sort(res);
        for (int i = 0; i < k; i++) {
            ans[i] = nums[res[i]];
        }
        return ans;
    }
}