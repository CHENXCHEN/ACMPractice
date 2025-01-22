package leetcode.normal.j1561;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-number-of-coins-you-can-get/description/">1561. 你可以获得的最大硬币数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length;
        int ans = 0;
        for (int i = 0, j = n - 2; i < j; i++, j -= 2) {
            ans += piles[j];
        }
        return ans;
    }
}