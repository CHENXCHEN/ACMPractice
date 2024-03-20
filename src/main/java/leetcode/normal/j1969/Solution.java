package leetcode.normal.j1969;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-non-zero-product-of-the-array-elements/description/">1969. 数组元素的最小非零乘积</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    long mod = (long) 1e9 + 7;

    public int minNonZeroProduct(int p) {
        if (p == 1) return 1;
        long x = fastPow(2L, p) - 1, n = 1L << (p - 1);
        return (int) (x * fastPow(x - 1, n - 1) % mod);
    }

    long fastPow(long x, long n) {
        long ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) ans = (ans * x) % mod;
            x = x * x % mod;
            n >>= 1;
        }
        return ans;
    }
}