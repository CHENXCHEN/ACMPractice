package leetcode.normal.j594;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/longest-harmonious-subsequence/description/">594. 最长和谐子序列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, i = 0, lastCnt = -1, lastNum = -1;
        while (i < nums.length) {
            int j = i;
            while (j < nums.length && nums[j] == nums[i]) j++;
            int curCnt = j - i;
            if (lastCnt != -1 && nums[i] - lastNum == 1) {
                ans = Math.max(ans, lastCnt + curCnt);
            }
            lastCnt = curCnt;
            lastNum = nums[i];
            i = j;
        }
        return ans;
    }
}