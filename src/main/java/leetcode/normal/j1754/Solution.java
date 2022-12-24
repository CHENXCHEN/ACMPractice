package leetcode.normal.j1754;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/largest-merge-of-two-strings/">1754. 构造字典序最大的合并字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            if (word1.charAt(i) == word2.charAt(j)) {
                int idx = 0;
                char wordFirst = word1.charAt(i);
                while ((i + idx) < word1.length() && (j + idx) < word2.length() &&
                        word1.charAt(i + idx) == wordFirst && word2.charAt(j + idx) == wordFirst) {
                    sb.append(word1.charAt(i + idx));
                    idx++;
                }
                int ret = cmp(word1, word2, i, j);
                if (ret > 0) i += idx;
                else j += idx;
            } else if (word1.charAt(i) > word2.charAt(j)) {
                sb.append(word1.charAt(i++));
            } else {
                sb.append(word2.charAt(j++));
            }
        }
        while (i < word1.length()) sb.append(word1.charAt(i++));
        while (j < word2.length()) sb.append(word2.charAt(j++));
        return sb.toString();
    }

    int cmp(String word1, String word2, int i, int j) {
        while (i < word1.length() && j < word2.length()) {
            int tmp = word1.charAt(i) - word2.charAt(j);
            if (tmp != 0) return tmp;
            i++;
            j++;
        }
        if (i != word1.length()) return 1;
        else if (j != word2.length()) return -1;
        return 0;
    }
}