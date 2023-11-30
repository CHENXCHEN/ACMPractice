package leetcode.normal.j1657;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/determine-if-two-strings-are-close/description/">1657. 确定两个字符串是否接近</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int n = word1.length();
        int[] cnt1 = new int[26], cnt2 = new int[26];
        for (int i = 0; i < n; i++) {
            cnt1[word1.charAt(i) - 'a']++;
            cnt2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if ((cnt1[i] > 0 || cnt2[i] > 0) && (cnt1[i] == 0 || cnt2[i] == 0)) {
                return false;
            }
        }
        Arrays.sort(cnt1);
        Arrays.sort(cnt2);
        return Arrays.equals(cnt1, cnt2);
    }
}