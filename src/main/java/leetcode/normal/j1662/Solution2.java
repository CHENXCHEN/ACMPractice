package leetcode.normal.j1662;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-if-two-string-arrays-are-equivalent/">1662. 检查两个字符串数组是否相等</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int idx1 = 0, pos1 = 0, idx2 = 0, pos2 = 0;
        while (idx1 < word1.length && idx2 < word2.length) {
            if (word1[idx1].charAt(pos1) != word2[idx2].charAt(pos2)) return false;
            ++pos1;
            ++pos2;
            if (pos1 == word1[idx1].length()) {
                ++idx1;
                pos1 = 0;
            }
            if (pos2 == word2[idx2].length()) {
                ++idx2;
                pos2 = 0;
            }
        }
        return idx1 == word1.length && idx2 == word2.length;
    }
}