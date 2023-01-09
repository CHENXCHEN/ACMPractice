package leetcode.normal.j1806;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-operations-to-reinitialize-a-permutation/">1806. 还原排列的最少操作步数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution3 {

    public int reinitializePermutation(int n) {
        if (n == 2) return 1;
        int step = 1, pow2 = 2, mod = n - 1;
        // 设 g(i) 为进行一次操作后，该元素的新的下标
        // 若 0 <= i < n/2，g(i) = 2*i
        // 若 n/2 <= i < n, g(i) = 2*i - (n-1)
        // g(g(i) = 2^2 * i % (n-1)
        // 找到 2^k % (n-1) == 1 的最小 k，则是需要转换的步骤了
        while (pow2 != 1) {
            step++;
            pow2 = (pow2 << 1) % mod;
        }
        return step;
    }
}