package leetcode.normal.j689;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-sum-of-3-non-overlapping-subarrays/description/">689. 三个无重叠子数组的最大和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution2 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        // maxSum[i] -> 表示到 下标为 i 为止，i 左边两个不相交的长度为 k 的数组的最大和是多少
        int[][] maxSum = new int[n][3];
        // preMax[i] 表示到下标 i 为止，长度为 k 的数组的和的最大值和下标
        int[][] preMax = new int[n][2];
        for (int i = 0; i + k < n; i++) {
            int cur = preSum[i + k] - preSum[i];
            if (i == 0 || preMax[i - 1][0] < cur) {
                preMax[i][0] = cur;
                preMax[i][1] = i;
            } else {
                preMax[i][0] = preMax[i - 1][0];
                preMax[i][1] = preMax[i - 1][1];
            }
            if (i - k >= 0) {
                cur += preMax[i - k][0];
                if (maxSum[i - 1][0] < cur) {
                    maxSum[i][0] = cur;
                    maxSum[i][1] = preMax[i - k][1];
                    maxSum[i][2] = i;
                } else {
                    maxSum[i][0] = maxSum[i - 1][0];
                    maxSum[i][1] = maxSum[i - 1][1];
                    maxSum[i][2] = maxSum[i - 1][2];
                }
            }
        }
        int mx = 0;
        int[] ans = new int[3];
        for (int i = 2 * k; i + k <= n; i++) {
            int sum = maxSum[i - k][0] + preSum[i + k] - preSum[i];
            if (sum > mx) {
                ans[0] = maxSum[i - k][1];
                ans[1] = maxSum[i - k][2];
                ans[2] = i;
                mx = sum;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums = {1, 2, 1, 2, 6, 7, 5, 1};
        solution2.maxSumOfThreeSubarrays(nums, 2);
    }
}
