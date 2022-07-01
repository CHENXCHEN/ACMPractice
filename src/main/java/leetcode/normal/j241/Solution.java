package leetcode.normal.j241;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/different-ways-to-add-parentheses/">241. 为运算表达式设计优先级</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int OP_ADD = -1, OP_DEL = -2, OP_MUL = -3;

    public List<Integer> diffWaysToCompute(String expression) {
        ArrayList<Integer> ops = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+') {
                ops.add(OP_ADD);
            } else if (ch == '-') {
                ops.add(OP_DEL);
            } else if (ch == '*') {
                ops.add(OP_MUL);
            } else {
                int num = ch - '0';
                if (i + 1 < expression.length() && Character.isDigit(expression.charAt(i + 1))) {
                    num = num * 10 + (expression.charAt(i + 1) - '0');
                    ++i;
                }
                ops.add(num);
            }
        }
        ArrayList<Integer>[][] dp = new ArrayList[ops.size()][ops.size()];
        for (int i = 0; i < ops.size(); i++) {
            for (int j = 0; j < ops.size(); j++) {
                dp[i][j] = new ArrayList<>();
            }
        }
        return dfs(0, ops.size() - 1, dp, ops);
    }

    ArrayList<Integer> dfs(int l, int r, ArrayList<Integer>[][] dp, ArrayList<Integer> ops) {
        if (dp[l][r].isEmpty()) {
            if (l == r) dp[l][r].add(ops.get(l));
            else {
                for (int i = l; i < r; i += 2) {
                    ArrayList<Integer> left = dfs(l, i, dp, ops);
                    ArrayList<Integer> right = dfs(i + 2, r, dp, ops);
                    Integer op = ops.get(i + 1);
                    for (Integer lVal : left) {
                        for (Integer rVal : right) {
                            if (op == OP_ADD) dp[l][r].add(lVal + rVal);
                            else if (op == OP_DEL) dp[l][r].add(lVal - rVal);
                            else dp[l][r].add(lVal * rVal);
                        }
                    }
                }
            }
        }
        return dp[l][r];
    }
}