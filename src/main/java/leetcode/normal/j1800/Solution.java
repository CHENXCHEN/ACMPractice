package leetcode.normal.j1800;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-ascending-subarray-sum/">1800. 最大升序子数组和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length, i = 0, ans = 0;
        while (i < n) {
            int tmp = nums[i];
            while (i + 1 < n && nums[i + 1] > nums[i]) {
                tmp += nums[i + 1];
                i++;
            }
            ans = Math.max(ans, tmp);
            i++;
        }
        return ans;
    }
}