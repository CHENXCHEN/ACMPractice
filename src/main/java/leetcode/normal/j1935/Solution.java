package leetcode.normal.j1935;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-number-of-words-you-can-type/description/">1935. 可以输入的最大单词数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int mask = 0;
        for (int i = 0; i < brokenLetters.length(); i++) {
            int idx = brokenLetters.charAt(i) - 'a';
            mask |= (1 << idx);
        }
        String[] words = text.split(" ");
        int ans = 0;
        for (String word : words) {
            if (isValid(word, mask)) {
                ans++;
            }
        }
        return ans;
    }

    boolean isValid(String word, int mask) {
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (((mask >> idx) & 1) == 1) {
                return false;
            }
        }
        return true;
    }
}