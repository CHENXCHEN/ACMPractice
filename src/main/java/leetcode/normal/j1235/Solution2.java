package leetcode.normal.j1235;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-profit-in-job-scheduling/">1235. 规划兼职工作</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Integer[] pos = new Integer[n];
        for (int i = 0; i < n; i++) pos[i] = i;
        int[] dp = new int[n + 1];
        Arrays.sort(pos, Comparator.comparingInt(i -> endTime[i]));
        for (int i = 1; i <= n; i++) {
            // 找到小于 startTime[pos[i-1]] 的最大 endTime 的 pos 坐标，要从 1 开始
            int k = binarySearch(endTime, pos, i - 1, startTime[pos[i - 1]]);
            // dp[i] 表示到第 i 个为止的最大收益是多少
            dp[i] = Math.max(dp[i - 1], dp[k] + profit[pos[i - 1]]);
        }
        return dp[n];
    }

    int binarySearch(int[] endTime, Integer[] pos, int right, int target) {
        int left = 0;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (endTime[pos[mid]] > target) right = mid;
            else left = mid + 1; // 我们让 mid + 1，刚好可以让它错位从 1 开始
        }
        return left;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] startTime = {1, 2, 3, 4, 6};
        int[] endTime = {3, 5, 10, 6, 9};
        int[] profit = {20, 20, 100, 70, 60};
        solution.jobScheduling(startTime, endTime, profit);
    }
}