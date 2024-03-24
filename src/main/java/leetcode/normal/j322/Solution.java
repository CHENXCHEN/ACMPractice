package leetcode.normal.j322;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/coin-change/description/">322. 零钱兑换</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] mem, coins;

    public int coinChange(int[] coins, int amount) {
        mem = new int[amount + 1];
        Arrays.sort(coins);
        this.coins = coins;
        Arrays.fill(mem, -1);
        mem[0] = 0;
        int res = dfs(amount);
        return res < 0 ? -1 : res;
    }

    int dfs(int tot) {
        if (mem[tot] != -1) return mem[tot];
        int ans = -2;
        for (int coin : coins) {
            if (tot >= coin) {
                int child = dfs(tot - coin);
                if (child >= 0 && (ans < 0 || child < ans)) {
                    ans = child + 1;
                }
            } else break;
        }
        mem[tot] = ans;
        return ans;
    }
}