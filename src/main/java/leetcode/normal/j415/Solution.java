package leetcode.normal.j415;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/add-strings/">415. 字符串相加</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        int flag = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || flag > 0; i--, j--) {
            int cur = flag;
            if (i >= 0) cur += num1.charAt(i) - '0';
            if (j >= 0) cur += num2.charAt(j) - '0';
            flag = cur / 10;
            sb.append(cur % 10);
        }
        return sb.reverse().toString();
    }
}