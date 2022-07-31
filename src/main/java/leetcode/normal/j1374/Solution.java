package leetcode.normal.j1374;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/generate-a-string-with-characters-that-have-odd-counts/">1374. 生成每种字符都是奇数个的字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String generateTheString(int n) {
        StringBuffer sb = new StringBuffer();
        if ((n & 1) == 1) {
            for (int i = 0; i < n; i++) sb.append('x');
        } else {
            for (int i = 0; i < n - 1; i++) sb.append('x');
            sb.append('y');
        }
        return sb.toString();
    }
}