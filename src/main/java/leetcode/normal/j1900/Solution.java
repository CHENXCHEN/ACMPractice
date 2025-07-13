package leetcode.normal.j1900;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/the-earliest-and-latest-rounds-where-players-compete/description/">1900. 最佳运动员的比拼回合</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][][] F = new int[30][30][30], G = new int[30][30][30];

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        // 先后位置对结果没影响
        if (firstPlayer > secondPlayer) {
            int tmp = firstPlayer;
            firstPlayer = secondPlayer;
            secondPlayer = tmp;
        }

        return dp(n, firstPlayer, secondPlayer);
    }

    int[] dp(int n, int f, int s) {
        if (F[n][f][s] != 0) {
            return new int[]{F[n][f][s], G[n][f][s]};
        }
        if (f + s == n + 1) {
            return new int[]{1, 1};
        }

        if (f + s > n + 1) {
            // 如果 f 和 s 都在右边，那么翻转一下，让他们都在左边
            int[] res = dp(n, n + 1 - s, n + 1 - f);
            F[n][f][s] = res[0];
            G[n][f][s] = res[1];
            return new int[]{F[n][f][s], G[n][f][s]};
        }

        int earlist = Integer.MAX_VALUE, latest = Integer.MIN_VALUE;
        int nHalf = (n + 1) / 2;
        if (s <= nHalf) {
            // 如果 s 在左侧或者中间，我们枚举下一轮 f 和 s 的相对位置
            // 枚举 f 左边的有 i 个赢了
            // 枚举 f 到 s 之间有 j 个赢了
            for (int i = 0; i < f; i++) {
                for (int j = 0; j < s - f; j++) {
                    int[] res = dp(nHalf, i + 1, i + j + 2);
                    earlist = Math.min(earlist, res[0]);
                    latest = Math.max(latest, res[1]);
                }
            }
        } else {
            // 如果 s 在右侧，sPrime 是 s 的对称位置，一定会输
            // 枚举 f 左边的有 i 个赢了
            // 枚举 sPrime 到 f 之间有 j 个赢了
            // 如果 sPrime < f，翻转一下，会使得 sPrime > f，在其他情况下可以枚举到，不用考虑
            int sPrime = n + 1 - s;
            // 这是 s 与 sPrime 之间经过一轮后剩余的人数
            int mid = (n - 2 * sPrime + 1) / 2;
            for (int i = 0; i < f; i++) {
                for (int j = 0; j < sPrime - f; j++) {
                    int[] res = dp(nHalf, i + 1, i + j + mid + 2);
                    earlist = Math.min(earlist, res[0]);
                    latest = Math.max(latest, res[1]);
                }
            }
        }

        F[n][f][s] = earlist + 1;
        G[n][f][s] = latest + 1;
        return new int[]{F[n][f][s], G[n][f][s]};
    }
}