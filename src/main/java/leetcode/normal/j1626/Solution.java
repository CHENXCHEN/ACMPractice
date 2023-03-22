package leetcode.normal.j1626;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/best-team-with-no-conflicts/">1626. 无矛盾的最佳球队</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length, ans = 0;
        Integer[] pos = new Integer[n];
        for (int i = 0; i < n; i++) pos[i] = i;
        Arrays.sort(pos, (x, y) -> {
            if (ages[x] != ages[y]) return ages[x] - ages[y];
            return scores[x] - scores[y];
        });
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int pos1 = pos[i];
            dp[i] = scores[pos1];
            for (int j = 0; j < i; j++) {
                int pos2 = pos[j];
                if (ages[pos1] == ages[pos2] || (ages[pos2] < ages[pos1] && scores[pos2] <= scores[pos1])) {
                    dp[i] = Math.max(dp[i], dp[j] + scores[pos1]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}