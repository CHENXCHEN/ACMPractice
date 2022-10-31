package leetcode.normal.j1662;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-if-two-string-arrays-are-equivalent/">1662. 检查两个字符串数组是否相等</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }
}