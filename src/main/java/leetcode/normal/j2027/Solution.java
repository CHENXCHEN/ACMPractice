package leetcode.normal.j2027;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-moves-to-convert-string/">2027. 转换字符串的最少操作次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumMoves(String s) {
        int cnt = 0, i = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) != 'X') ++i;
            if (i < s.length()) ++cnt;
            i += 3;
        }
        return cnt;
    }
}