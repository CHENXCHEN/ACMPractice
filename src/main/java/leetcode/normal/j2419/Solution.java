package leetcode.normal.j2419;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/longest-subarray-with-maximum-bitwise-and/description/">2419. 按位与最大的最长子数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int longestSubarray(int[] nums) {
        int last = -1, lastCnt = 0, i = 0;
        while (i < nums.length) {
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            int cnt = j - i;
            if (nums[i] > last) {
                last = nums[i];
                lastCnt = cnt;
            } else if (nums[i] == last) {
                lastCnt = Math.max(cnt, lastCnt);
            }
            i = j;
        }
        return lastCnt;
    }
}