package leetcode.normal.j1922;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-good-numbers/description/">1922. 统计好数字的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    long MOD = (long) 1e9 + 7;

    public int countGoodNumbers(long n) {
        if (n == 1) return 5;
        // 偶数：0,2,4,6,8
        // 质数：2,3,5,7
        // 如果 n 是偶数，那么答案为 20^(n/2)
        // 如果 n 是奇数，那么答案为 20^(n/2) * 5，因为最后一位一定是偶数
        if ((n & 1) == 0) {
            return (int) (fastPow(20, n >> 1));
        } else {
            return (int) (fastPow(20, n >> 1) * 5 % MOD);
        }
    }

    long fastPow(long x, long n) {
        long ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = (ans * x) % MOD;
            }
            x = (x * x) % MOD;
            n >>= 1;
        }
        return ans;
    }
}