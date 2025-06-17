package leetcode.normal.j3405;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-the-number-of-arrays-with-k-matching-adjacent-elements/description/">3405. 统计恰好有 K 个相等相邻元素的数组数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    static final int MOD = (int) 1e9 + 7;
    static final int MX = 100000;
    // 除法的取模，如果 p 是质数，那么 (a / b) % p = (a * b^(p-2)) % p
    static long[] fact = new long[MX];
    static long[] invFact = new long[MX];

    static long fastPow(long x, int n) {
        long res = 1L;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = (res * x) % MOD;
            }
            x = (x * x) % MOD;
            n >>= 1;
        }
        return res;
    }

    static {
        fact[0] = 1;
        for (int i = 1; i < MX; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        invFact[MX - 1] = fastPow(fact[MX - 1], MOD - 2);
        for (int i = MX - 1; i > 0; i--) {
            invFact[i - 1] = invFact[i] * i % MOD;
        }
    }

    // 计算 C(n, m) 排列组合数，从 n 个元素中选 m 个的组合数
    long comb(int n, int m) {
        return fact[n] * invFact[m] % MOD * invFact[n - m] % MOD;
    }

    public int countGoodArrays(int n, int m, int k) {
        // 长度为 n 的数组，一共有 n - 1 对相邻的元素，问只有 k 对相邻元素相等的组合数是多少
        // 要有 k 对相邻的元素相等，剩余的 n - k - 1 对相邻的元素不能相等
        // 使用插板法，n - k - 1 对相邻不相等的元素把 k 对相邻且相等元素分开
        // 1. 在 n - 1 个空位中，选择 n - k - 1 个插入隔板，为 C(n - 1, n - 1 - k) = C(n - 1, k)
        // 2. 第一段中所有元素都一样，取值没有限制，所以第一段有 m 种
        // 3. 第二段以及后面的所有段要和前面的取值不一样，有 m - 1 种取值，且有 n - k - 1 段，所以有 (m - 1)^(n - k - 1)
        return (int) (comb(n - 1, k) * m % MOD * fastPow(m - 1, n - k - 1) % MOD);
    }
}