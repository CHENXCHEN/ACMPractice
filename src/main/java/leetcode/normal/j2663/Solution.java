package leetcode.normal.j2663;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/lexicographically-smallest-beautiful-string/description/">2663. 字典序最小的美丽字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String smallestBeautifulString(String s, int k) {
        int idx = -1, n = s.length();
        StringBuilder sb = new StringBuilder(s);
        for (int i = n - 1; i >= 0; i--) {
            int pos = s.charAt(i) - 'a';
            for (int j = pos + 1; j < k; j++) {
                char ch = (char) ('a' + j);
                if (!isSame(s, i - 1, ch) && !isSame(s, i - 2, ch)) {
                    idx = i;
                    sb.setCharAt(i, ch);
                    break;
                }
            }
            if (idx >= 0) break;
        }
        if (idx == -1) return "";
        for (int i = idx + 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                char ch = (char) ('a' + j);
                if (!isSame(sb, i - 1, ch) && !isSame(sb, i - 2, ch)) {
                    sb.setCharAt(i, ch);
                    break;
                }
            }
        }
        return sb.toString();
    }

    boolean isSame(CharSequence s, int idx1, char ch) {
        if (idx1 < 0) return false;
        return s.charAt(idx1) == ch;
    }
}