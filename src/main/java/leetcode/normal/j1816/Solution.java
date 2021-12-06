package leetcode.normal.j1816;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/truncate-sentence/submissions/
 * 1816. 截断句子
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String truncateSentence(String s, int k) {
        int cnt = 0, i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') cnt++;
            if (cnt == k) break;
            i++;
        }
        return s.substring(0, i);
    }
}