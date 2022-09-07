package leetcode.normal.j828;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-unique-characters-of-all-substrings-of-a-given-string/">828. 统计子串中的唯一字符</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int uniqueLetterString(String s) {
        int[][] prePos = new int[26][s.length()], nextPos = new int[26][s.length()];
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'A';
            for (int j = 0; j < 26; j++) {
                prePos[j][i] = i == 0 ? -1 : prePos[j][i - 1];
            }
            prePos[cur][i] = i;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            int cur = s.charAt(i) - 'A';
            for (int j = 0; j < 26; j++) {
                nextPos[j][i] = i == s.length() - 1 ? s.length() : nextPos[j][i + 1];
            }
            nextPos[cur][i] = i;
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int leftPos = i, rightPos = i;
            int cur = s.charAt(i) - 'A';
            if (i != 0) leftPos = prePos[cur][i - 1] + 1;
            if (i != s.length() - 1) rightPos = nextPos[cur][i + 1] - 1;
            int leftCnt = i - leftPos, rightCnt = rightPos - i;
            ans += leftCnt + rightCnt + 1 + leftCnt * rightCnt;
        }
        return ans;
    }
}