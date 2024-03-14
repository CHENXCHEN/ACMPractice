package leetcode.normal.j2789;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/largest-element-in-an-array-after-merge-operations/description/"></a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long maxArrayValue(int[] nums) {
        int n = nums.length, lastIdx = n - 1;
        long lastSum = nums[lastIdx], ans = nums[lastIdx];
        for (int i = lastIdx - 1; i >= 0; i--) {
            if (nums[i] <= lastSum) {
                lastSum += nums[i];
            } else {
                while (lastIdx > i && lastSum < nums[i]) {
                    lastSum -= nums[lastIdx--];
                }
                if (lastIdx == i) {
                    lastSum = 0;
                }
                lastSum += nums[i];
            }
            ans = Math.max(ans, lastSum);
        }
        return ans;
    }
}