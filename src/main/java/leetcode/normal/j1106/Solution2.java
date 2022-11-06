package leetcode.normal.j1106;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/parsing-a-boolean-expression/">1106. 解析布尔表达式</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    String exp;

    public boolean parseBoolExpr(String expression) {
        this.exp = expression;
        return dfs(0, exp.length() - 1);
    }

    boolean dfs(int start, int end) {
        char ch = exp.charAt(start);
        if (ch == 't') return true;
        else if (ch == 'f') return false;
        else {
            if (ch == '!') return !dfs(start + 2, end - 1);
            else {
                int level = 0, idxFrom = start + 2;
                for (int i = idxFrom; i <= end - 1; i++) {
                    char cur = exp.charAt(i);
                    if (cur == '(') ++level;
                    else if (cur == ')') --level;
                    else if (cur == ',' && level == 0) {
                        boolean check = dfs(idxFrom, i - 1);
                        if (ch == '|' && check) return true;
                        else if (ch == '&' && !check) return false;
                        idxFrom = i + 1;
                    }
                }
                // 这里是对 & 和 | 操作的最后一个动作的结果，&(...,&(..))，这个结果是 true or false 决定整个表达式的结果
                return dfs(idxFrom, end - 1);
            }
        }
    }
}