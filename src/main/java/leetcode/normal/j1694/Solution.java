package leetcode.normal.j1694;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/reformat-phone-number/">1694. 重新格式化电话号码</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))) {
                sb.append(number.charAt(i));
            }
        }
        StringBuilder ans = new StringBuilder();
        int i = 0, n = sb.length();
        while (i < n) {
            if (n - i == 4) {
                ans.append(sb.substring(i, i + 2)).append('-').append(sb.substring(i + 2, i + 4));
                break;
            } else {
                for (int j = 0; j < 3 && i < n; j++, i++) {
                    ans.append(sb.charAt(i));
                }
                if (i != n) ans.append('-');
            }
        }
        return ans.toString();
    }
}