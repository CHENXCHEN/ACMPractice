package leetcode.normal.j1704;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/determine-if-string-halves-are-alike/">1704. 判断字符串的两半是否相似</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean halvesAreAlike(String s) {
        char[] chs = {'a', 'e', 'i', 'o', 'u'};
        int[] has = new int[26];
        int len = s.length();
        int half = len >> 1;
        for (int i = 0; i < len; i++) {
            int ch = Character.toLowerCase(s.charAt(i)) - 'a';
            if (i < half) has[ch]++;
            else has[ch]--;
        }
        int cnt = 0;
        for (char ch : chs) {
            cnt += has[ch - 'a'];
        }
        return cnt == 0;
    }
}