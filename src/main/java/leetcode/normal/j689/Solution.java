package leetcode.normal.j689;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/maximum-sum-of-3-non-overlapping-subarrays/
 * 689. 三个无重叠子数组的最大和
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];
        int[][] leftMax = new int[nums.length][2];
        int[][] rightMax = new int[nums.length][2];
        preSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) preSum[i] = preSum[i - 1] + nums[i - 1];
        for (int i = 0; i + k - 1 < nums.length; i++) {
            int si = preSum[i + k] - preSum[i];
            if (i == 0 || si > leftMax[i - 1][0]) {
                leftMax[i][0] = si;
                leftMax[i][1] = i;
            } else {
                leftMax[i][0] = leftMax[i - 1][0];
                leftMax[i][1] = leftMax[i - 1][1];
            }
        }
        for (int i = nums.length - k; i >= 0; i--) {
            int si = preSum[i + k] - preSum[i];
            if (i == nums.length - k || si >= rightMax[i + 1][0]) {
                rightMax[i][0] = si;
                rightMax[i][1] = i;
            } else {
                rightMax[i][0] = rightMax[i + 1][0];
                rightMax[i][1] = rightMax[i + 1][1];
            }
        }
        int maxAns = 0;
        int[] maxArr = new int[3];
        for (int i = k; i + k + k - 1 < nums.length; i++) {
            int si = preSum[i + k] - preSum[i];
            int res = leftMax[i - k][0] + si + rightMax[i + k][0];
            if (res > maxAns) {
                maxAns = res;
                maxArr[0] = leftMax[i - k][1];
                maxArr[1] = i;
                maxArr[2] = rightMax[i + k][1];
            }
        }
        return maxArr;
    }
}