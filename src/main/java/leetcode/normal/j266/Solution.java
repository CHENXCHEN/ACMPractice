package leetcode.normal.j266;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/palindrome-permutation/description/">266. 回文排列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a'] ^= 1;
        }
        int oddNum = 0;
        for (int i = 0; i < 26; i++) {
            oddNum += count[i];
        }
        if (oddNum > 1 || (oddNum == 1 && (s.length() & 1) == 0)) return false;
        return true;
    }
}