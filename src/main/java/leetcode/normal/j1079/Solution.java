package leetcode.normal.j1079;

import java.util.HashSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/letter-tile-possibilities/">1079. 活字印刷</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    HashSet<String> tSet;
    String tiles;
    int[] cnt;

    public int numTilePossibilities(String tiles) {
        tSet = new HashSet<>();
        this.tiles = tiles;
        cnt = new int[26];
        for (int i = 0; i < tiles.length(); i++) {
            cnt[tiles.charAt(i) - 'A']++;
        }
        dfs(tiles.length(), "");
        return tSet.size();
    }

    void dfs(int left, String sb) {
        // 枚举所有情况，路径上的字符串都加入集合
        if (sb.length() > 0) {
            tSet.add(sb);
        }
        if (left == 0) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                char ch = (char) ('A' + i);
                --cnt[i];
                dfs(left - 1, sb + ch);
                ++cnt[i];
            }
        }
    }
}