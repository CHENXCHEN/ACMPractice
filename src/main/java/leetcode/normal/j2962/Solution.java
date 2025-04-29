package leetcode.normal.j2962;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/">2962. 统计最大元素出现至少 K 次的子数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxNum = Integer.MIN_VALUE, n = nums.length;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        int cnt = 0;
        long ans = 0;
        boolean valid = false;
        for (int right = 0, left = 0; right < n; right++) {
            if (nums[right] == maxNum) ++cnt;
            if (cnt >= k) valid = true;
            while (left <= right && cnt >= k) {
                if (nums[left] == maxNum) --cnt;
                left++;
            }
            if (valid) {
                ans += left;
            }
        }
        return ans;
    }
}