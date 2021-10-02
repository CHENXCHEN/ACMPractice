package leetcode.normal.j405;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/submissions/
 * 405. 数字转换为十六进制数
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    String hexString = "0123456789abcdef";

    public String toHex(int num) {
        if (num == 0) return "0";
        if (num == Integer.MIN_VALUE) return "80000000";
        int tran = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        while (tran != 0 && sb.length() < 9) {
            int mod = tran % 16;
            sb.append(hexString.charAt(mod));
            tran /= 16;
        }
        if (num < 0) {
            for (int i = sb.length(); i < 8; i++) sb.append('0');
            // 获得反码
            for (int i = 0; i < sb.length(); i++) {
                char ch = sb.charAt(i);
                int revNum = (~hexString.indexOf(ch)) & 0xf;
                sb.setCharAt(i, hexString.charAt(revNum));
            }
            for (int i = 0; i < sb.length(); i++) {
                char ch = sb.charAt(i);
                if (ch == 'f') sb.setCharAt(i, '0');
                else {
                    sb.setCharAt(i, hexString.charAt(hexString.indexOf(ch) + 1));
                    break;
                }
            }
        }
        return sb.reverse().toString();
    }
}