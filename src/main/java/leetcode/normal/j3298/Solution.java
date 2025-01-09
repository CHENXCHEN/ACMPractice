package leetcode.normal.j3298;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-ii/description/"></a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long validSubstringCount(String word1, String word2) {
        int[] dictCnt = new int[26];
        // 记录 word2 中出现的不同字母数以及每个字母出现的次数
        int distinctCharCnt = 0;
        for (int i = 0; i < word2.length(); i++) {
            if (dictCnt[word2.charAt(i) - 'a']++ == 0) {
                ++distinctCharCnt;
            }
        }
        long ans = 0;
        for (int i = 0, left = 0; i < word1.length(); i++) {
            if (--dictCnt[word1.charAt(i) - 'a'] == 0) {
                --distinctCharCnt;
            }
            // 对于当前位置 i，找到最小的符合条件的窗口 [left-1, i]
            while (distinctCharCnt == 0) {
                char outChar = word1.charAt(left++);
                if (dictCnt[outChar - 'a']++ == 0) {
                    distinctCharCnt++;
                }
            }
            ans += left;
        }
        return ans;
    }
}