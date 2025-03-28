package leetcode.normal.j2712;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-cost-to-make-all-characters-equal/description/">2712. 使所有字符相等的最小成本</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long minimumCost(String s) {
        int n = s.length();
        // suf[i][1] 表示将 [i..n-1] 操作为 1 的最小花费，suf[i][0] 表示将 [i..n-1] 操作为 0 的最小花费
        long[][] suf = new long[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                suf[i][1] = suf[i + 1][1];
                suf[i][0] = suf[i + 1][1] + (n - i);
            } else {
                suf[i][1] = suf[i + 1][0] + (n - i);
                suf[i][0] = suf[i + 1][0];
            }
        }
        long[] pre = new long[2];
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                pre[0] = pre[1] + i + 1;
            } else {
                pre[1] = pre[0] + i + 1;
            }
            ans = Math.min(ans, Math.min(pre[0] + suf[i + 1][0], pre[1] + suf[i + 1][1]));
        }
        return ans;
    }
}