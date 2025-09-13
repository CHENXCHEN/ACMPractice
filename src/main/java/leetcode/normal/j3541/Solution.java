package leetcode.normal.j3541;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-most-frequent-vowel-and-consonant/description/">3541. 找到频率最高的元音和辅音</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxFreqSum(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        int mx1 = 0, mx2 = 0;
        for (int i = 0; i < cnt.length; i++) {
            char ch = (char) ('a' + i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                mx1 = Math.max(mx1, cnt[i]);
            } else {
                mx2 = Math.max(mx2, cnt[i]);
            }
        }
        return mx1 + mx2;
    }
}