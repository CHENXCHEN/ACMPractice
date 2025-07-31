package leetcode.normal.jmst0102;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-permutation-lcci/">面试题 01.02. 判定是否互为字符重排</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] has = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            has[s1.charAt(i) - 'a']++;
            has[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (has[i] != 0) return false;
        }
        return true;
    }
}