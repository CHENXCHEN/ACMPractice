package leetcode.normal.j2697;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/lexicographically-smallest-palindrome/description/">2697. 字典序最小回文串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String makeSmallestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        int left = 0, right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                char ch = sb.charAt(left) > sb.charAt(right) ? sb.charAt(right) : sb.charAt(left);
                sb.setCharAt(left, ch);
                sb.setCharAt(right, ch);
            }
            ++left;
            --right;
        }
        return sb.toString();
    }
}