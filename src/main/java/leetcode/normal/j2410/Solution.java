package leetcode.normal.j2410;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-matching-of-players-with-trainers/">2410. 运动员和训练师的最大匹配数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int m = players.length, n = trainers.length;
        int ans = 0;
        for (int i = 0, j = 0; i < m && j < n; i++, j++) {
            while (j < n && players[i] > trainers[j]) ++j;
            if (j < n) ++ans;
        }
        return ans;
    }
}