package leetcode.normal.j370;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/range-addition/">370. 区间加法</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        for (int[] op : updates) {
            ans[op[0]] += op[2];
            if (op[1] != length - 1) {
                ans[op[1] + 1] -= op[2];
            }
        }
        for (int i = 1; i < ans.length; i++) {
            ans[i] += ans[i-1];
        }
        return ans;
    }
}