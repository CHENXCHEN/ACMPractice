package leetcode.normal.j521;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/longest-uncommon-subsequence-i/description/">521. 最长特殊序列 Ⅰ</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) return -1;
        return Math.max(b.length(), a.length());
    }
}