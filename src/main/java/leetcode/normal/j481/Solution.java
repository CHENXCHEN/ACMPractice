package leetcode.normal.j481;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/magical-string/">481. 神奇字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int magicalString(int n) {
        char[] ss = new char[n + 2];
        ss[0] = '1';
        ss[1] = '2';
        ss[2] = '2';
        char turn = '1';
        int ans = 1, tot = 1;
        for (int i = 1; i < n; i++) {
            turn = turn == '1' ? '2' : '1';
            if (ss[i] == '1') {
                ++ans;
            } else {
                if (tot < n) ss[tot++] = turn;
            }
            if (tot < n) ss[tot++] = turn;
        }
        return ans;
    }
}