package leetcode.normal.j473;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/matchsticks-to-square/
 * 473. 火柴拼正方形
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    boolean isCan = false;

    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) return false;
        int sum = 0;
        for (int matchstick : matchsticks) sum += matchstick;
        if (sum % 4 != 0) return false;
        int[] edge = new int[4];
        isCan = false;
        Arrays.sort(matchsticks);
        dfs((1 << matchsticks.length) - 1, edge, matchsticks, sum / 4, 0, 0);
        return isCan;
    }

    void dfs(int cur, int[] edge, int[] matchsticks, int avg, int step, int nowEdge) {
        if (edge[nowEdge] == avg) {
            nowEdge++;
            step = 0;
        }
        if (isCan || (nowEdge == 4)) {
            isCan = true;
            return;
        }
        for (int i = step; i < matchsticks.length; i++) {
            int curBit = 1 << i;
            if (edge[nowEdge] + matchsticks[i] <= avg) {
                if ((cur & curBit) != 0) {
                    edge[nowEdge] += matchsticks[i];
                    dfs(cur ^ curBit, edge, matchsticks, avg, i + 1, nowEdge);
                    edge[nowEdge] -= matchsticks[i];
                }
            } else break;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] sticks = {3, 1, 3, 3, 10, 7, 10, 3, 6, 9, 10, 3, 7, 6, 7};
        System.out.println(solution.makesquare(sticks));
    }
}