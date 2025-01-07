package leetcode.normal.j2264;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/largest-3-same-digit-number-in-string/description/">2264. 字符串中最大的 3 位相同数字</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String largestGoodInteger(String num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i - 1) && num.charAt(i) == num.charAt(i - 2)) {
                if (sb.length() == 0 || sb.charAt(0) < num.charAt(i)) {
                    if (sb.length() > 0) sb.deleteCharAt(0);
                    sb.append(num.charAt(i));
                }
            }
        }
        if (sb.length() == 0) return "";
        sb.append(sb.charAt(0)).append(sb.charAt(0));
        return sb.toString();
    }
}