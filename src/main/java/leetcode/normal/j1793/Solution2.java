package leetcode.normal.j1793;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-score-of-a-good-subarray/description/">1793. 好子数组的最大分数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int maximumScore(int[] nums, int k) {
        int left = k - 1, right = k + 1;
        int n = nums.length, ans = nums[k], record = nums[k];
        while (left >= 0 || right < n) {
            while (left >= 0 && nums[left] >= record) --left;
            while (right < n && nums[right] >= record) ++right;
            ans = Math.max(ans, (right - left - 1) * record);
            record = Math.max(left == -1 ? -1 : nums[left], right == n ? -1 : nums[right]);
        }
        return ans;
    }
}