package leetcode.normal.j368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/largest-divisible-subset/description/">368. 最大整除子集</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n], parent = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(dp, 1);
        int max = Integer.MIN_VALUE, idx = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                idx = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (idx != -1) {
            ans.add(nums[idx]);
            idx = parent[idx];
        }
        return ans;
    }
}