package leetcode.normal.j1255;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-score-words-formed-by-letters/">1255. 得分最高的单词集合</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] wordCnt;
    int[] score;
    int[] letterCnt;
    int n;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.score = score;
        n = words.length;
        wordCnt = new int[n][26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                ++wordCnt[i][words[i].charAt(j) - 'a'];
            }
        }
        letterCnt = new int[26];
        for (char letter : letters) {
            ++letterCnt[letter - 'a'];
        }
        int tot = 1 << n, ans = 0;
        for (int i = 1; i < tot; i++) {
            ans = Math.max(ans, checkSituation(i));
        }
        return ans;
    }

    int checkSituation(int mask) {
        int[] cnt = new int[26];
        int totScore = 0;
        for (int i = 0; i < n; i++) {
            if (((mask >> i) & 1) == 1) {
                for (int j = 0; j < 26; j++) {
                    cnt[j] += wordCnt[i][j];
                    if (cnt[j] > letterCnt[j]) return 0;
                    totScore += wordCnt[i][j] * score[j];
                }
            }
        }
        return totScore;
    }
}