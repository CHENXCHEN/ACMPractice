package leetcode.normal.j2302;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-subarrays-with-score-less-than-k/description/">2302. 统计得分小于 K 的子数组数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long ans = 0, sum = 0;
        for (int right = 0, left = 0; right < n; right++) {
            sum += nums[right];
            while (left <= right && sum * (right - left + 1) >= k) {
                sum -= nums[left];
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}