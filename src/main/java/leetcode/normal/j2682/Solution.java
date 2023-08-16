package leetcode.normal.j2682;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-losers-of-the-circular-game/">2682. 找出转圈游戏输家</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean[] vis = new boolean[n];
        int cur = 0, lag = k;
        while (!vis[cur]) {
            vis[cur] = true;
            cur = (cur + lag) % n;
            lag = (lag + k) % n;
        }
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (!vis[i]) lst.add(i);
        }
        int[] ans = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++) ans[i] = lst.get(i) + 1;
        return ans;
    }
}