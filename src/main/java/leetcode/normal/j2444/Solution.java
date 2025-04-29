package leetcode.normal.j2444;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-subarrays-with-fixed-bounds/description/">2444. 统计定界子数组的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int lastMin = -1, lastMax = -1, border = -1, n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                lastMin = -1;
                lastMax = -1;
                border = i;
                continue;
            }
            if (nums[i] == minK) lastMin = i;
            if (nums[i] == maxK) lastMax = i;
            if (lastMin != -1 && lastMax != -1) {
                ans += Math.min(lastMin, lastMax) - border;
            }
        }
        return ans;
    }
}