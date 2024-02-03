package leetcode.normal.j1686;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/stone-game-vi/description/">1686. 石子游戏 VI</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        // 对于两个位置 (i,j)：
        // alice 取 i 的差值为 a[i] - b[j]，alice 取 j 的差值为 a[j] - b[i]，那么 alice 每次优先取其中之一最大值
        //      即，a[i] - b[j] - (a[j] - b[i]) 如果 > 0 则取 i，否则取 j
        //         => a[i] + b[i] - (a[j] + b[j])
        //         每次不管谁面临剩下的情况，都优先取最大的值
        int n = aliceValues.length;
        Integer[] pos = new Integer[n];
        for (int i = 0; i < n; i++) pos[i] = i;
        Arrays.sort(pos, (a, b) -> Integer.compare(aliceValues[b] + bobValues[b], aliceValues[a] + bobValues[a]));
        int score1 = 0, score2 = 0;
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) score1 += aliceValues[pos[i]];
            else score2 += bobValues[pos[i]];
        }
        if (score1 == score2) return 0;
        return score1 > score2 ? 1 : -1;
    }
}