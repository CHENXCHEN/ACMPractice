package leetcode.normal.j1014;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/best-sightseeing-pair/description/">1014. 最佳观光组合</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int preMax = values[0];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, preMax + values[i] - i);
            preMax = Math.max(preMax, values[i] + i);
        }
        return ans;
    }
}