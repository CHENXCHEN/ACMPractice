package leetcode.normal.j2691;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/string-rotation-lcci/">面试题 01.09. 字符串轮转</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }
}