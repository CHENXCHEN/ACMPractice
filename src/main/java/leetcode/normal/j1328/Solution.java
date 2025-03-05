package leetcode.normal.j1328;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/break-a-palindrome/description/">1328. 破坏回文串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() <= 1) return "";
        StringBuilder res = new StringBuilder(palindrome);
        int n = palindrome.length();
        for (int i = 0; i < n; i++) {
            if (n % 2 == 1 && i == n / 2) continue;
            if (palindrome.charAt(i) != 'a') {
                res.setCharAt(i, 'a');
                break;
            }
        }
        if (res.toString().equals(palindrome)) {
            for (int i = n - 1; i >= 0; i--) {
                if (n % 2 == 1 && i == n / 2) continue;
                if (palindrome.charAt(i) != 'z') {
                    res.setCharAt(i, (char) (palindrome.charAt(i) + 1));
                    break;
                }
            }
        }
        return res.toString().equals(palindrome) ? "" : res.toString();
    }
}