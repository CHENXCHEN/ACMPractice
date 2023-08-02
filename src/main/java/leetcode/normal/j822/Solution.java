package leetcode.normal.j822;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/card-flipping-game/">822. 翻转卡片游戏</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int n = fronts.length;
        boolean[] vis = new boolean[2001];
        for (int i = 0; i < n; i++) {
            if (fronts[i] == backs[i]) vis[fronts[i]] = true;
        }
        int ans = 2001;
        for (int i = 0; i < n; i++) {
            if (!vis[fronts[i]]) {
                ans = Math.min(ans, fronts[i]);
            }
            if (!vis[backs[i]]) {
                ans = Math.min(ans, backs[i]);
            }
        }
        return ans == 2001 ? 0 : ans;
    }
}
