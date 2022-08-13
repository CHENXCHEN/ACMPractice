package leetcode.normal.j1422;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-score-after-splitting-a-string/">1422. 分割字符串的最大得分</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxScore(String s) {
        int[] leftCnt = new int[s.length()], rightCnt = new int[s.length()];
        for (int i = 0; i < s.length(); i++)
            leftCnt[i] += 1 - (s.charAt(i) - '0') + (i == 0 ? 0 : leftCnt[i - 1]);
        for (int i = s.length() - 1; i >= 0; i--)
            rightCnt[i] += s.charAt(i) - '0' + (i == s.length() - 1 ? 0 : rightCnt[i + 1]);
        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            ans = Math.max(ans, leftCnt[i] + rightCnt[i + 1]);
        }
        return ans;
    }
}