package leetcode.normal.j792;

import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-matching-subsequences/">792. 匹配子序列的单词数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    TreeSet<Integer>[] pos = new TreeSet[26];

    public int numMatchingSubseq(String s, String[] words) {
        for (int i = 0; i < 26; i++) pos[i] = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - 'a'].add(i);
        }
        int ans = 0;
        for (String word : words) {
            if (checkWord(word)) ans++;
        }
        return ans;
    }

    boolean checkWord(String word) {
        int from = -1;
        for (int i = 0; i < word.length(); i++) {
            Integer higher = pos[word.charAt(i) - 'a'].higher(from);
            if (higher == null) return false;
            from = higher;
        }
        return true;
    }
}