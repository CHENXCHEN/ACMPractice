package leetcode.normal.j736;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/parse-lisp-expression/">736. Lisp 语法解析</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int start = 0;
    TreeMap<String, ArrayDeque<Integer>> var = new TreeMap<>();

    public int evaluate(String expression) {
        return innerEval(expression);
    }

    int innerEval(String expr) {
        // 如果不是表达式
        if (expr.charAt(start) != '(') {
            if (Character.isLowerCase(expr.charAt(start))) { // 如果是变量
                String varName = parseVar(expr);
                return var.get(varName).peek();
            } else { // 整数
                return parseInt(expr);
            }
        }
        int ret;
        start++; // 跳过 (
        if (expr.charAt(start) == 'l') { // let
            ArrayList<String> vars = new ArrayList<>();
            start += 4; // 跳过 "let "
            while (true) {
                if (!Character.isLowerCase(expr.charAt(start))) { // 如果不是小写字母开头，说明是表达式
                    ret = innerEval(expr);
                    break;
                }
                String varName = parseVar(expr);
                if (expr.charAt(start) == ')') { // 如果到了表达式末尾
                    ret = var.get(varName).peek();
                    break;
                }
                start++; // 跳过空格
                int varAns = innerEval(expr);
                start++; // 跳过空格
                var.putIfAbsent(varName, new ArrayDeque<>());
                var.get(varName).push(varAns);
                vars.add(varName);
            }
            // 移除作用域
            for (String varName : vars) {
                var.get(varName).pop();
            }
        } else if (expr.charAt(start) == 'a') { // add
            start += 4; // 跳过 "add "
            int leftOp = innerEval(expr);
            start++; // 跳过空格
            int rightOp = innerEval(expr);
            ret = leftOp + rightOp;
        } else { // mul
            start += 5; // 跳过 "mult "
            int leftOp = innerEval(expr);
            start++; // 跳过空格
            int rightOp = innerEval(expr);
            ret = leftOp * rightOp;
        }
        start++; // 移除右括号
        return ret;
    }

    String parseVar(String expr) {
        int i = start;
        while (Character.isLetterOrDigit(expr.charAt(i))) i++;
        String ans = expr.substring(start, i);
        start = i;
        return ans;
    }

    int parseInt(String expr) {
        int i = start;
        if (expr.charAt(i) == '-') i++;
        while (Character.isDigit(expr.charAt(i))) i++;
        int ans = Integer.parseInt(expr.substring(start, i));
        start = i;
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.evaluate("(let x 2 y 3 x (add x y) x)"));
        System.out.println(solution.evaluate("(let x 7 -12)"));
    }
}