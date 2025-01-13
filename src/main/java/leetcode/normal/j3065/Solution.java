package leetcode.normal.j3065;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-operations-to-exceed-threshold-value-i/description/">3065. 超过阈值的最少操作数 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minOperations(int[] nums, int k) {
        int ans = 0;
        for (int num : nums) {
            if (num < k) ans++;
        }
        return ans;
    }
}