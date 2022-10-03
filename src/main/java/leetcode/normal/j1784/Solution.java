package leetcode.normal.j1784;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-if-binary-string-has-at-most-one-segment-of-ones/">1784. 检查二进制字符串字段</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}
