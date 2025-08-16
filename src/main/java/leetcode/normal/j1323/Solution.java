package leetcode.normal.j1323;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-69-number/description/">1323. 6 和 9 组成的最大数字</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximum69Number (int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        for (int i = 0;i < sb.length();i++) {
            if (sb.charAt(i) == '6') {
                sb.setCharAt(i, '9');
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}