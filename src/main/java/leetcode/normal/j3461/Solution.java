package leetcode.normal.j3461;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-if-digits-are-equal-in-string-after-operations-i/">3461. 判断操作后字符串中的数字是否相等 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean hasSameDigits(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i) - '0');
        }
        while (list.size() > 2) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < list.size() - 1; i++) {
                temp.add((list.get(i) + list.get(i + 1)) % 10);
            }
            list = temp;
        }
        return Objects.equals(list.get(0), list.get(1));
    }
}