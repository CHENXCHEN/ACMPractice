package leetcode.normal.j3096;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-levels-to-gain-more-points/description/">3096. 得到更多分数的最少关卡数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumLevels(int[] possible) {
        int n = possible.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += possible[i] == 0 ? -1 : 1;
        }
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            res += possible[i] == 0 ? -1 : 1;
            if (res > sum - res) {
                return i + 1;
            }
        }
        return -1;
    }
}