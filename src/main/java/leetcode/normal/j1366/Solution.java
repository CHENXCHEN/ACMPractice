package leetcode.normal.j1366;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/rank-teams-by-votes/description/">1366. 通过投票对团队排名</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String rankTeams(String[] votes) {
        int n = votes.length, m = votes[0].length();
        int[][] cnt = new int[26][26];
        boolean[] visited = new boolean[26];
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                cnt[vote.charAt(i) - 'A'][i]++;
                visited[vote.charAt(i) - 'A'] = true;
            }
        }
        Integer[] pos = new Integer[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = i;
        }
        Arrays.sort(pos, (x, y) -> {
            // 先按照投票排名，某个投票名次更大的优先
            for (int i = 0; i < 26; i++) {
                if (cnt[x][i] != cnt[y][i]) return cnt[y][i] - cnt[x][i];
            }
            // 如果相等，则字母小的优先
            return x - y;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (visited[pos[i]]) {
                sb.append((char) ('A' + pos[i]));
            }
        }
        return sb.toString();
    }
}