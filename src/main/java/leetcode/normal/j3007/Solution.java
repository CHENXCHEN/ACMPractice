package leetcode.normal.j3007;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-number-that-sum-of-the-prices-is-less-than-or-equal-to-k/description/">3007. 价值和小于等于 K 的最大数字</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long findMaximumNumber(long k, int x) {
        // 二分答案，因为结果具有单调性：随着 num 增加，1...num 的价值和也随之增加
        // 因此二分 num，求当值为 num 时，价值和为多少
        long left = 1, right = (k + 1) << x, ans = 1;
        while (left <= right) {
            long mid = (left + right) >> 1;
            if (calcPrice(x, mid) <= k) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    long calcPrice(int x, long num) {
        // 求 num 的价值和为多少，观察可知，从二进制位数看，只有当前 x 位有贡献，可以拆开看，[0, x), [x, 2x)
        // 当 x = 0 时，其左半周期内的每个值，贡献为0；当 x = 1 时，右半周期的每个值，贡献为1
        // 因此以 x 为倍数，计算它的所有倍数的每个周期对 1 的贡献和即可
        long res = 0;
        int len = 64 - Long.numberOfLeadingZeros(num);
        for (int i = x; i <= len; i += x) {
            res += calcBitPrice(i, num);
        }
        return res;
    }

    long calcBitPrice(int x, long num) {
        long period = 1L << x;
        // 计算有多少个周期，每个周期的贡献1的个数为 2x - x - 1 = x - 1，x - 1 个二进制位，其值为 2^(x-1)
        long res = (period >> 1) * (num / period);
        if (num % period >= (period >> 1)) {
            res += num % period - (period >> 1) + 1;
        }
        return res;
    }
}