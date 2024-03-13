package leetcode.normal.j2864;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-odd-binary-number/description/">2864. 最大二进制奇数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String maximumOddBinaryNumber(String s) {
        int len = s.length(), cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt += s.charAt(i) == '1' ? 1 : 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt - 1; i++) {
            sb.append('1');
        }
        for (int i = cnt - 1; i < s.length() - 1; i++) {
            sb.append('0');
        }
        sb.append('1');
        return sb.toString();
    }
}