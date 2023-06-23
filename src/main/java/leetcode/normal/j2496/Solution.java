package leetcode.normal.j2496;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-value-of-a-string-in-an-array/">2496. 数组中字符串的最大值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximumValue(String[] strs) {
        int ans = 0;
        for (String str : strs) {
            ans = Math.max(ans, getLen(str));
        }
        return ans;
    }

    int getLen(String str) {
        if (isNumeric(str)) {
            return Integer.parseInt(str);
        }
        return str.length();
    }

    boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}