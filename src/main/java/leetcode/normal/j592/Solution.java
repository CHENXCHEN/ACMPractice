package leetcode.normal.j592;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/fraction-addition-and-subtraction/">592. 分数加减运算</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String fractionAddition(String expression) {
        ArrayList<int[]> expr = new ArrayList<>();
        for (int i = 0; i < expression.length(); ) {
            char ch = expression.charAt(i);
            int sigh = 1;
            if (ch == '-') sigh = -1;
            if (ch == '+' || ch == '-') i++;
            int num1 = 0, num2 = 0;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                num1 = num1 * 10 + (expression.charAt(i) - '0');
                ++i;
            }
            ++i;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                num2 = num2 * 10 + (expression.charAt(i) - '0');
                ++i;
            }
            expr.add(new int[]{sigh * num1, num2});
        }
        int[] ans = new int[]{0, 1};
        for (int[] vv : expr) {
            if (ans[0] == 0) {
                ans[0] = vv[0];
                ans[1] = vv[1];
                continue;
            }
            // a / b + c / d = ad/(bd) + cb/(bd) = (ad + cb) / (bd)
            int num1 = ans[0] * vv[1] + ans[1] * vv[0];
            int num2 = ans[1] * vv[1];
            int curGcd = gcd(num1, num2);
            num1 /= curGcd;
            num2 /= curGcd;
            if (num1 < 0 && num2 < 0) {
                num1 = -num1;
                num2 = -num2;
            } else if (num2 < 0) {
                num1 = -num1;
                num2 = -num2;
            }
            if (num1 == 0) {
                num2 = 1;
            }
            ans[0] = num1;
            ans[1] = num2;
        }
        return String.format("%d/%d", ans[0], ans[1]);
    }

    int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
}
