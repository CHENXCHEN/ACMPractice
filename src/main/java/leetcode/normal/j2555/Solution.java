package leetcode.normal.j2555;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximize-win-from-two-segments/description/">2555. 两个线段获得的最多奖品</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        // leftMax[i] => 到 i - 1 为止，长度不超过 k 的最大礼物数
        // rightMax[i] => 到 i 为止，长度不超过 k 的最大礼物数
        int[] leftMax = new int[n + 1], rightMax = new int[n + 1];
        int last = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            while (prizePositions[i] - prizePositions[last] > k) {
                sum--;
                last++;
            }
            sum++;
            leftMax[i + 1] = Math.max(leftMax[i], sum);
        }
        last = n - 1;
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (prizePositions[last] - prizePositions[i] > k) {
                sum--;
                last--;
            }
            sum++;
            rightMax[i] = Math.max(rightMax[i + 1], sum);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, leftMax[i] + rightMax[i]);
        }
        return ans;
    }
}