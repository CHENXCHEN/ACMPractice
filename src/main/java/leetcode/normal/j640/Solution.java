package leetcode.normal.j640;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/solve-the-equation/">640. 求解方程</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String solveEquation(String equation) {
        int pos = equation.indexOf('=');
        int[] ret1 = getRet(equation.substring(0, pos));
        int[] ret2 = getRet(equation.substring(pos + 1));
        int[] ans = {ret1[0] - ret2[0], ret2[1] - ret1[1]};
        if (ans[0] == 0 && ans[1] != 0) {
            return "No solution";
        }
        else if (ans[0] == 0) {
            return "Infinite solutions";
        } else {
            return "x=" + (ans[1] / ans[0]);
        }
    }

    int[] getRet(String s) {
        int[] ans = new int[2];
        int i = 0;
        while (i < s.length()) {
            int sigh = 1;
            if (s.charAt(i) == '-') {
                sigh = -1;
                ++i;
            } else if (s.charAt(i) == '+') ++i;
            int j = i;
            while (j < s.length() && (s.charAt(j) != '+' && s.charAt(j) != '-')) j++;
            String sub = s.substring(i, j);
            if (sub.endsWith("x")) {
                if (sub.equals("x")) {
                    ans[0] += sigh;
                } else {
                    ans[0] += sigh * Integer.parseInt(sub.substring(0, sub.length() - 1));
                }
            } else {
                ans[1] += sigh * Integer.parseInt(sub);
            }
            i = j;
        }
        return ans;
    }
}