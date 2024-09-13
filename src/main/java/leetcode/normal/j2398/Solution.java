package leetcode.normal.j2398;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-number-of-robots-within-budget/description/">2398. 预算内的最多机器人数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] mx;
    long[] preSum;

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        mx = new int[n][16];
        preSum = new long[n + 1];
        for (int i = 0; i < n; i++) mx[i][0] = chargeTimes[i];
        for (int j = 1; j < 16; j++) {
            int cnt = (1 << j), half = cnt >> 1;
            for (int i = 0; i < n; i++) {
                int left = mx[i][j - 1];
                int right = i + half < n ? mx[i + half][j - 1] : 0;
                mx[i][j] = Math.max(left, right);
            }
        }
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + runningCosts[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int len = binarySearch(i, budget);
            ans = Math.max(ans, len);
        }
        return ans;
    }

    int binarySearch(int end, long budget) {
        int left = 0, right = end, ans = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            long sum = getMax(mid, end) + (end - mid + 1) * (preSum[end + 1] - preSum[mid]);
            if (sum <= budget) {
                ans = end - mid + 1;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    int getMax(int left, int right) {
        int cnt = (right - left + 1);
        int bitCnt = 0;
        while (cnt > 0) {
            bitCnt++;
            cnt >>= 1;
        }
        if (bitCnt == 0) return mx[left][0];
        System.out.printf("left: %d right: %d cnt: %d bitCnt: %d\n", left, right, cnt, bitCnt);
        return Math.max(mx[left][bitCnt - 1], mx[right - (1 << (bitCnt - 1)) + 1][bitCnt - 1]);
    }
}