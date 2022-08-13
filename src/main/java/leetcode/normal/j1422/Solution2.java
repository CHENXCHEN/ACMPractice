package leetcode.normal.j1422;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-score-after-splitting-a-string/">1422. 分割字符串的最大得分</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int maxScore(String s) {
        int score = 0;
        if (s.charAt(0) == '0') score++;
        for (int i = 1; i < s.length(); i++) score += s.charAt(i) - '0';
        int ans = score;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') score--;
            else score++;
            ans = Math.max(ans, score);
        }
        return ans;
    }
}