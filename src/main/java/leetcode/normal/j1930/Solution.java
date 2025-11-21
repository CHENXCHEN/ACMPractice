package leetcode.normal.j1930;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/unique-length-3-palindromic-subsequences/description/">1930. 长度为 3 的不同回文子序列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] leftMask = new int[n];
        int[] rightMask = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0) leftMask[i] = leftMask[i - 1];
            leftMask[i] |= 1 << (s.charAt(i) - 'a');
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i + 1 < n) rightMask[i] = rightMask[i + 1];
            rightMask[i] |= 1 << (s.charAt(i) - 'a');
        }
        Set<String> ss = new HashSet<>();
        for (int i = 1; i < n - 1; i++) {
            int both = leftMask[i - 1] & rightMask[i + 1];
            addToMark(ss, s.charAt(i), both);
        }
        return ss.size();
    }

    void addToMark(Set<String> set, char ch, int mask) {
        for (int i = 0; i < 26; i++) {
            if (((mask >> i) & 1) == 1) {
                char cur = (char) ('a' + i);
                set.add(String.valueOf(cur) + ch + cur);
            }
        }
    }
}