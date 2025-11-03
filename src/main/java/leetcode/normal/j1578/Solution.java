package leetcode.normal.j1578;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-time-to-make-rope-colorful/">1578. 使绳子变成彩色的最短时间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0, i = 0;
        while (i < colors.length()) {
            int j = i + 1;
            int sum = neededTime[i], max = neededTime[i];
            while (j < colors.length() && colors.charAt(i) == colors.charAt(j)) {
                sum += neededTime[j];
                max = Math.max(max, neededTime[j]);
                j++;
            }
            ans += sum - max;
            i = j;
        }
        return ans;
    }
}