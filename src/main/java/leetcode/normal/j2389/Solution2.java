package leetcode.normal.j2389;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/longest-subsequence-with-limited-sum/">2389. 和有限的最长子序列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = findQuery(preSum, queries[i]) + 1;
        }
        return ans;
    }

    int findQuery(int[] preSum, int query) {
        int left = 0, right = preSum.length - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (preSum[mid] <= query) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }
}