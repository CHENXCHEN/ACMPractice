package leetcode.normal.j667;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/beautiful-arrangement-ii/">667. 优美的排列 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int idx = 0;
        for (int i = 1; i < n - k; i++) {
            ans[idx++] = i;
        }
        for (int i = n - k, j = n; i <= j; i++, j--) {
            ans[idx++] = i;
            if (i != j) ans[idx++] = j;
        }
        return ans;
    }
}