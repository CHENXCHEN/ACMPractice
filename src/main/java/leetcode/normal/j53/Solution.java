package leetcode.normal.j53;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-subarray/description/">https://leetcode.cn/problems/maximum-subarray/description/</a>
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int lastSum = 0;
        for (int num: nums) {
            lastSum += num;
            ans = Math.max(ans, lastSum);
            if (lastSum < 0) lastSum = 0;
        }
        return ans;
    }
}