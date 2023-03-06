package leetcode.normal.j1653;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/">1653. 使字符串平衡的最少删除次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int minimumDeletions(String s) {
        int ans = Integer.MAX_VALUE, cntB = 0, cntA = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a') ++cntA;
        }
        for (char ch : s.toCharArray()) {
            if (ch == 'a') --cntA;
            ans = Math.min(ans, cntA + cntB);
            if (ch == 'b') ++cntB;
        }
        return ans;
    }
}