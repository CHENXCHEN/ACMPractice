package leetcode.dweek.j79.j6083;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/check-if-number-has-equal-digit-count-and-digit-value/
 * 6083. 判断一个数的数字计数是否等于数位的值
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean digitCount(String num) {
        int[] has = new int[11];
        for (int i = 0; i < num.length(); i++) {
            has[num.charAt(i) - '0']++;
        }
        for (int i = 0; i < num.length(); i++) {
            if (has[i] != (num.charAt(i) - '0')) return false;
        }
        return true;
    }
}