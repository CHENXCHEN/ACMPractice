package leetcode.normal.j2278;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/percentage-of-letter-in-string/description/">2278. 字母在字符串中的百分比</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int percentageLetter(String s, char letter) {
        int n = s.length(), cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == letter) {
                cnt++;
            }
        }
        return cnt * 100 / n;
    }
}