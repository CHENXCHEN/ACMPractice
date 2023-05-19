package leetcode.normal.j1079;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/letter-tile-possibilities/">1079. 活字印刷</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    String tiles;
    int[] cnt;

    public int numTilePossibilities(String tiles) {
        this.tiles = tiles;
        cnt = new int[26];
        for (int i = 0; i < tiles.length(); i++) {
            cnt[tiles.charAt(i) - 'A']++;
        }
        // 计算出所有情况后，减去空集
        return dfs(tiles.length()) - 1;
    }

    int dfs(int left) {
        if (left == 0) return 1;
        int res = 1;
        // 枚举所有情况
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                --cnt[i];
                res += dfs(left - 1);
                ++cnt[i];
            }
        }
        return res;
    }
}