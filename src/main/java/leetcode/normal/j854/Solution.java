package leetcode.normal.j854;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/k-similar-strings/">854. 相似度为 K 的字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int ans;

    public int kSimilarity(String s1, String s2) {
        ans = s1.length();
        dfs(0, 0, s1, s2);
        return ans;
    }

    void dfs(int pos, int cost, String s1, String s2) {
        if (cost > ans) return;
        while (pos < s1.length() && s1.charAt(pos) == s2.charAt(pos)) ++pos;
        if (pos == s1.length()) {
            ans = cost;
            return;
        }
        if (cost + minSwapNum(s1, s2, pos) > ans) return;
        boolean isFoundSwap = false;
        for (int i = pos + 1; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i) && s1.charAt(i) == s2.charAt(pos) && s2.charAt(i) == s1.charAt(pos)) {
                isFoundSwap = true;
                String next = swap(s1, i, pos);
                dfs(pos + 1, cost + 1, next, s2);
                break;
            }
        }
        if (!isFoundSwap) {
            for (int i = pos + 1; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i) && s1.charAt(i) == s2.charAt(pos)) {
                    String next = swap(s1, i, pos);
                    dfs(pos + 1, cost + 1, next, s2);
                }
            }
        }
    }

    int minSwapNum(String s1, String s2, int pos) {
        int cnt = 0;
        for (int i = pos; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) ++cnt;
        }
        return (cnt + 1) >> 1;
    }

    String swap(String s, int p1, int p2) {
        char[] chars = s.toCharArray();
        char tmp = chars[p1];
        chars[p1] = chars[p2];
        chars[p2] = tmp;
        return new String(chars);
    }
}