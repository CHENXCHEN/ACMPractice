package leetcode.normal.j1052;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/grumpy-bookstore-owner/description/">1052. 爱生气的书店老板</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int[] preSum = new int[n + 1], pureSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + customers[i];
            pureSum[i + 1] = pureSum[i] + (grumpy[i] == 1 ? 0 : customers[i]);
        }
        if (minutes >= n) return preSum[n];
        int ans = pureSum[n];
        for (int i = 0; i + minutes - 1 < n; i++) {
            ans = Math.max(ans, pureSum[n] - (pureSum[i + minutes] - pureSum[i]) + preSum[i + minutes] - preSum[i]);
        }
        return ans;
    }
}