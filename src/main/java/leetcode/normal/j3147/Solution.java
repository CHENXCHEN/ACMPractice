package leetcode.normal.j3147;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/taking-maximum-energy-from-the-mystic-dungeon/description/">3147. 从魔法师身上吸取的最大能量</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length, ans = energy[n - 1];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < k) dp[i] = energy[i];
            else dp[i] = Math.max(dp[i - k] + energy[i], energy[i]);
        }
        for (int i = n - k; i < n; i++) ans = Math.max(ans, dp[i]);
        return ans;
    }
}