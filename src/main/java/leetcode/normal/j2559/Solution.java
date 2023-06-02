package leetcode.normal.j2559;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-vowel-strings-in-ranges/">2559. 统计范围内的元音字符串数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    boolean[] mark = new boolean[256];

    public int[] vowelStrings(String[] words, int[][] queries) {
        mark['a'] = mark['e'] = mark['i'] = mark['o'] = mark['u'] = true;
        int[] preSum = new int[words.length + 1];
        for (int i = 0; i < words.length; i++) {
            preSum[i + 1] = preSum[i] + (checkStr(words[i]) ? 1 : 0);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = preSum[queries[i][1] + 1] - preSum[queries[i][0]];
        }
        return ans;
    }

    boolean checkStr(String word) {
        return mark[word.charAt(0)] && mark[word.charAt(word.length() - 1)];
    }
}