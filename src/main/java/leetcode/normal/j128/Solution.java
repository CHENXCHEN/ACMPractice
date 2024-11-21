package leetcode.normal.j128;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/longest-consecutive-sequence/description/">128. 最长连续序列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int ans = 1, cnt = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
            if (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                ++cnt;
            } else {
                ans = Math.max(ans, cnt);
                cnt = 1;
            }
        }
        ans = Math.max(ans, cnt);
        return ans;
    }
}