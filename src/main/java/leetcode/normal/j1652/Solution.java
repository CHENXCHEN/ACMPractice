package leetcode.normal.j1652;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/defuse-the-bomb/">1652. 拆炸弹</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] preSum = new int[n << 1];
        preSum[0] = code[0];
        for (int i = 1; i < n; i++) preSum[i] = preSum[i - 1] + code[i];
        for (int i = n, j = 0; j < n; j++, i++) preSum[i] = preSum[i - 1] + code[j];
        int[] ans = new int[n];
        if (k == 0) return ans;
        for (int i = 0; i < n; i++) {
            if (k > 0) {
                ans[i] = preSum[i + k] - preSum[i];
            } else {
                ans[i] = preSum[i + n - 1] - preSum[i + n + k - 1];
            }
        }
        return ans;
    }
}