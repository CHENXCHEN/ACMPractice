package leetcode.normal.jlcp61;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/6CE719/description/">LCP 61. 气温变化趋势</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int n = temperatureA.length, i = 0, ans = 0;
        while (i < n) {
            int cnt = 0;
            while (i + 1 < n && Integer.compare(temperatureA[i], temperatureA[i + 1]) == Integer.compare(temperatureB[i], temperatureB[i + 1])) {
                ++cnt;
                ++i;
            }
            ++i;
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}