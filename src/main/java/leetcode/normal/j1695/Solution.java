package leetcode.normal.j1695;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-erasure-value/description/">1695. 删除子数组的最大得分</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int[] lastIdx = new int[10001];
        Arrays.fill(lastIdx, -1);
        int ans = 0, cur = 0, left = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            while (left <= lastIdx[nums[i]]) {
                cur -= nums[left];
                left++;
            }
            lastIdx[nums[i]] = i;
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}