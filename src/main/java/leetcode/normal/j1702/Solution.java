package leetcode.normal.j1702;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-binary-string-after-change/description/">1702. 修改后的最大二进制字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String maximumBinaryString(String binary) {
        StringBuilder sb = new StringBuilder(binary);
        int n = binary.length();
        for (int i = 0, j = 0; i < n; i++) {
            if (sb.charAt(i) == '0') {
                while (j <= i || (j < n && sb.charAt(j) == '1')) ++j;
                if (j < n) {
                    sb.setCharAt(i, '1');
                    sb.setCharAt(j, '1');
                    sb.setCharAt(i + 1, '0');
                }
            }
        }
        return sb.toString();
    }
}