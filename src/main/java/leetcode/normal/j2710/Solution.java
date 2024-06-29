package leetcode.normal.j2710;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/remove-trailing-zeros-from-a-string/description/">2710. 移除字符串中的尾随零</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String removeTrailingZeros(String num) {
        int right = num.length() - 1;
        while (right >= 0 && num.charAt(right) == '0') right--;
        return num.substring(0, right + 1);
    }
}