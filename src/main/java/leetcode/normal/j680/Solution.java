package leetcode.normal.j680;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/valid-palindrome-ii/description/">680. 验证回文串 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (check(s.substring(left + 1, right + 1)) || check(s.substring(left, right))) {
                    return true;
                } else return false;
            }
            left++;
            right--;
        }
        return true;
    }

    boolean check(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}