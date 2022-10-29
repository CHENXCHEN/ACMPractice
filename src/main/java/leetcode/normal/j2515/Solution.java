package leetcode.normal.j2515;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/3aqs1c/">LCP 65. 舒适的湿度</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int unSuitability(int[] operate) {
        int max = (Arrays.stream(operate).max().getAsInt() << 1) | 1;
        int[][] dp = new int[2][max];
        int pos = 0;
        Arrays.fill(dp[pos], Integer.MAX_VALUE);
        dp[pos][0] = 0;
        for (int x : operate) {
            int[] pre = dp[pos], cur = dp[pos ^ 1];
            Arrays.fill(cur, Integer.MAX_VALUE);
            for (int j = 0; j < max; j++) {
                int dis = pre[j];
                if (dis == Integer.MAX_VALUE) continue;
                if (j + x < max) cur[j + x] = Math.min(cur[j + x], Math.max(dis, j + x));
                if (j >= x) cur[j - x] = Math.min(cur[j - x], dis);
                else cur[0] = Math.min(cur[0], dis - j + x);
            }
            pos ^= 1;
        }
        return Arrays.stream(dp[pos]).min().getAsInt();
    }
}