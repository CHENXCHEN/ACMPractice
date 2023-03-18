package leetcode.normal.j2389;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/longest-subsequence-with-limited-sum/">2389. 和有限的最长子序列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        Integer[] pos = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) pos[i] = i;
        Arrays.sort(pos, (x, y) -> queries[x] - queries[y]);
        int ss = 0, qPos = 0, last = 0;
        int[] ans = new int[queries.length];
        for (int i = 0; i < nums.length && qPos < queries.length; i++) {
            ss += nums[i];
            if (ss > queries[pos[qPos]]) {
                ++qPos;
                while (qPos < queries.length && ss > queries[pos[qPos]]) {
                    ans[pos[qPos++]] = last;
                }
            }
            if (qPos < queries.length && ss <= queries[pos[qPos]]) {
                last = i + 1;
                ans[pos[qPos]] = i + 1;
            }
        }
        while (qPos < queries.length) ans[pos[qPos++]] = last;
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 5, 2, 1}, queries = {3, 10, 21};
        solution.answerQueries(nums, queries);
    }
}