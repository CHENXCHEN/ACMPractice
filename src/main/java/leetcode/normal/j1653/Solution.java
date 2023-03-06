package leetcode.normal.j1653;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/">1653. 使字符串平衡的最少删除次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumDeletions(String s) {
        int[] preSum = new int[s.length() + 1];
        for (int i = s.length() - 1; i >= 0; i--) {
            preSum[i] = preSum[i + 1] + (s.charAt(i) == 'a' ? 1 : 0);
        }
        int ans = Integer.MAX_VALUE, cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            ans = Math.min(ans, cnt + preSum[i + 1]);
            cnt += (s.charAt(i) == 'b' ? 1 : 0);
        }
        return ans;
    }
}