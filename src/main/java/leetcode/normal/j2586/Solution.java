package leetcode.normal.j2586;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-the-number-of-vowel-strings-in-range/description/">2586. 统计范围内的元音字符串数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        boolean[] mark = new boolean[26];
        String str = "aeiou";
        for (int i = 0; i < str.length(); i++) mark[str.charAt(i) - 'a'] = true;
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (mark[words[i].charAt(0) - 'a'] && mark[words[i].charAt(words[i].length() - 1) - 'a'])
                ++ans;
        }
        return ans;
    }
}