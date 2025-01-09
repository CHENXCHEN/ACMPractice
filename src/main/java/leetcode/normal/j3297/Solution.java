package leetcode.normal.j3297;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-i/description/">3297. 统计重新排列后包含另一个字符串的子字符串数目 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long validSubstringCount(String word1, String word2) {
        int[] res = new int[26];
        for (int i = 0; i < word2.length(); i++) res[word2.charAt(i) - 'a']++;
        int[] cnt = new int[26];
        long ans = 0;
        int left = 0, right = 0;
        while (left < word1.length()) {
            while (right < word1.length() && !isGreaterOrEqual(cnt, res)) {
                cnt[word1.charAt(right) - 'a']++;
                right++;
            }
            if (isGreaterOrEqual(cnt, res)) {
                ans += word1.length() - right + 1;
            }
            cnt[word1.charAt(left) - 'a']--;
            left++;
        }
        return ans;
    }

    boolean isGreaterOrEqual(int[] cnt1, int[] cnt2) {
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] < cnt2[i]) return false;
        }
        return true;
    }

}