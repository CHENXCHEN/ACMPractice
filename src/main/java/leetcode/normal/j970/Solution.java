package leetcode.normal.j970;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/powerful-integers/">970. 强整数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        TreeSet<Integer> num1 = new TreeSet<>(), num2 = new TreeSet<>();
        TreeSet<Integer> ans = new TreeSet<>();
        preProcess(num1, x, bound);
        preProcess(num2, y, bound);
        for (Integer numX : num1) {
            for (Integer numY : num2) {
                if (numX + numY <= bound) ans.add(numX + numY);
                else break;
            }
        }
        return new ArrayList<>(ans);
    }

    void preProcess(TreeSet<Integer> num, int k, int bound) {
        for (int i = 0, tk = 1; ; i++, tk *= k) {
            if (!num.add(tk) || tk > bound) {
                break;
            }
        }
    }
}