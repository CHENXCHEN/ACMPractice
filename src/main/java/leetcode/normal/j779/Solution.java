package leetcode.normal.j779;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/k-th-symbol-in-grammar/">779. 第K个语法符号</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int kthGrammar(int n, int k) {
        if (k == 1) return 0;
        else if (k == 2) return 1;
        int grammer = kthGrammar(n - 1, (k + 1) >> 1);
        if (grammer == 0) {
            return ((k - 1) & 1) == 1 ? 1 : 0;
        } else {
            return ((k - 1) & 1) == 1 ? 0 : 1;
        }
    }
}