package leetcode.normal.j3101;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-alternating-subarrays/description/">3101. 交替子数组计数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long ans = 0;
        int i = 0, j, n = nums.length;
        while (i < n) {
            j = i + 1;
            while (j < n && nums[j] != nums[j - 1]) j++;
            int cnt = j - i;
            ans += (cnt + 1L) * cnt / 2;
            i = j;
        }
        return ans;
    }
}