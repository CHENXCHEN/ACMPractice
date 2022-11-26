package leetcode.normal.j809;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/expressive-words/">809. 情感丰富的文字</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for (String word : words) {
            if (checkIfExtend(s, word)) ++ans;
        }
        return ans;
    }

    boolean checkIfExtend(String s, String word) {
        int i = 0, j = 0;
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) != word.charAt(j)) return false;
            int cnt1 = 0, cnt2 = 0;
            char ch = s.charAt(i);
            while (i < s.length() && s.charAt(i) == ch) {
                ++cnt1;
                ++i;
            }
            while (j < word.length() && word.charAt(j) == ch) {
                ++cnt2;
                ++j;
            }
            if (cnt2 > cnt1 || (cnt1 != cnt2 && cnt1 == 2)) return false;
        }
        return i == s.length() && j == word.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"hello", "hi", "helo"};
        solution.expressiveWords("heeellooo", strs);
    }
}