package leetcode.normal.j1134;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/armstrong-number/description/">1134. 阿姆斯特朗数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isArmstrong(int n) {
        long ans = 0;
        ArrayList<Integer> digits = new ArrayList<>();
        int cur = n;
        while (cur > 0) {
            digits.add(cur % 10);
            cur /= 10;
        }
        int digitNum = digits.size();
        for (int i = 0; i < digits.size(); i++) {
            ans += (long) Math.pow(digits.get(i), digitNum);
        }
        return (int) ans == n;
    }
}