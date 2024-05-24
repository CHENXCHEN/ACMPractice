package leetcode.normal.j1673;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-most-competitive-subsequence/description/">1673. 找出最具竞争力的子序列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && n - i + dq.size() > k && dq.peek() > nums[i]) {
                dq.pop();
            }
            dq.push(nums[i]);
        }
        while (dq.size() > k) dq.pop();
        int[] ans = new int[k];
        int i = 0;
        while (!dq.isEmpty()) {
            ans[k - i - 1] = dq.pop();
            i++;
        }
        return ans;
    }
}