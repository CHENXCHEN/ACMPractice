package leetcode.normal.j3343;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-number-of-balanced-permutations/description/">3343. 统计平衡排列的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    static int MOD = 1_000_000_007;
    static int MX = 41;
    // f[i] = i!
    static long[] F = new long[MX];
    // inv_f[i] = i!^-1
    // 除法取模的逆
    // 公式：(a / b) % p = (a * b^(p-2)) % p，当 a = 1 时
    // 公式：(1 / b) % p = b^(p-2) % p
    // INV_F[i] = (1 / i!) % p
    static long[] INV_F = new long[MX];

    static {
        F[0] = 1;
        for (int i = 1; i < MX; i++) {
            F[i] = F[i - 1] * i % MOD;
        }
        INV_F[MX - 1] = fastPow(F[MX - 1], MOD - 2);
        for (int i = MX - 1; i > 0; i--) {
            INV_F[i - 1] = INV_F[i] * i % MOD;
        }
    }

    static long fastPow(long x, int n) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1) res = res * x % MOD;
            x = x * x % MOD;
            n >>= 1;
        }
        return res;
    }

    public int countBalancedPermutations(String num) {
        int[] cnt = new int[10];
        int total = 0;
        for (char c : num.toCharArray()) {
            cnt[c - '0']++;
            total += c - '0';
        }
        // 如果是奇数，一定不能组成
        if ((total & 1) == 1) return 0;
        // 计算[0..i]的总个数
        for (int i = 1; i < 10; i++) {
            cnt[i] += cnt[i - 1];
        }

        int n = num.length();
        int n1 = n / 2;
        int[][][] memo = new int[10][n1 + 1][total / 2 + 1];
        for (int[][] mat : memo) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }
        return (int) (F[n1] * F[n - n1] % MOD * dfs(9, n1, total / 2, cnt, memo) % MOD);
    }

    // 表示，当前取的数字为 i 时，还剩下 left1 个数据，剩下和为 leftS 的情况数
    // 当取数字为 i 时候，取 0 个，取 1 个，取 2 个....取 c 个 i 时的情况数加起来即可
    // 需要注意的是，除法取模，需要用到 INV_F[k] 和 INV_F[c - k]
    int dfs(int i, int left1, int leftS, int[] cnt, int[][][] memo) {
        if (i < 0) {
            return leftS == 0 ? 1 : 0;
        }
        if (memo[i][left1][leftS] != -1) return memo[i][left1][leftS];
        long res = 0;
        // 计算当前数字 i 的个数有多少
        int c = cnt[i] - (i > 0 ? cnt[i - 1] : 0);
        // 当 left1 + left2 = cnt[i]，表示 left1 取了多少个，那么剩下都是 left2
        int left2 = cnt[i] - left1;
        // 要满足 k <= left1，因为不能超过 left1 的限制，且要满足 c - k <= left2，因为取了之后，不能超过 left2 的限制
        // max(c - left2,0) <= k <= min(c, left1)，为当前可以取的i的个数
        for (int k = Math.max(c - left2, 0); k <= Math.min(c, left1) && k * i <= leftS; k++) {
            long r = dfs(i - 1, left1 - k, leftS - k * i, cnt, memo);
            res = (res + r * INV_F[k] % MOD * INV_F[c - k]) % MOD;
        }
        return memo[i][left1][leftS] = (int) res;
    }
}