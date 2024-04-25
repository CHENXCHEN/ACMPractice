package leetcode.normal.j2739;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/total-distance-traveled/description/">2739. 总行驶距离</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int ans = 0;
        while (mainTank >= 5) {
            int cnt = mainTank / 5;
            ans += cnt * 5;
            int valid = Math.min(cnt, additionalTank);
            mainTank = mainTank % 5 + valid;
            additionalTank -= valid;
        }
        ans += mainTank;
        return ans * 10;
    }
}