package leetcode.normal.j3238;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-number-of-winning-players/description/">3238. 求出胜利玩家的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        int[][] has = new int[n][11];
        for (int[] item : pick) {
            has[item[0]][item[1]]++;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 11; j++) {
                if (has[i][j] > i) {
                    ++ans;
                    break;
                }
            }
        }
        return ans;
    }
}