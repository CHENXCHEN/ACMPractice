package leetcode.normal.j1658;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/">1658. 将 x 减到 0 的最小操作数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minOperations(int[] nums, int x) {
        if (nums[0] == x) return 1;
        long leftSum = 0, rightSum = Arrays.stream(nums).sum();
        if (rightSum < x) return -1;
        int n = nums.length;
        int rightPos = 0, ans = n + 1;
        for (int i = -1; i < n; i++) {
            if (i != -1) leftSum += nums[i];
            while (i >= rightPos) rightSum -= nums[rightPos++];
            while (rightPos < n && leftSum + rightSum > x) {
                rightSum -= nums[rightPos++];
            }
            if (leftSum + rightSum == x)
                ans = Math.min(ans, i + 1 + n - rightPos);
        }
        return ans > n ? -1 : ans;
    }
}