package leetcode.normal.j1684;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-the-number-of-consistent-strings/">1684. 统计一致字符串的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] vis = new boolean[26];
        for (int i = 0; i < allowed.length(); i++) {
            vis[allowed.charAt(i) - 'a'] = true;
        }
        int ans = 0;
        for (String word : words) {
            if (check(vis, word)) ans++;
        }
        return ans;
    }

    boolean check(boolean[] vis, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!vis[word.charAt(i) - 'a']) return false;
        }
        return true;
    }
}