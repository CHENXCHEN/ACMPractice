package leetcode.normal.j1031;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-sum-of-two-non-overlapping-subarrays/">1031. 两个非重叠子数组的最大和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int ans1 = 0, ans2 = 0, n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) preSum[i + 1] = preSum[i] + nums[i];
        for (int i = 0, endI = i + firstLen - 1; endI < n; i++, endI++) {
            for (int j = 0, endJ = j + secondLen - 1; endJ < n; j++, endJ++) {
                if ((i <= j && j <= endI) || (i <= endJ && endJ <= endI) || (j <= i && i <= endJ) || (j <= endI && endI <= endJ))
                    continue;
                int sum1 = preSum[i + firstLen] - preSum[i];
                int sum2 = preSum[j + secondLen] - preSum[j];
                if (sum1 + sum2 > ans1 + ans2) {
                    ans1 = sum1;
                    ans2 = sum2;
                }
            }
        }
        return ans1 + ans2;
    }
}