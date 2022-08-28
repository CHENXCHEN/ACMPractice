package leetcode.normal.j793;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/preimage-size-of-factorial-zeroes-function/">793. 阶乘函数后 K 个零</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int preimageSizeFZF(int k) {
        // 答案为 (末尾 0 的个数为 k + 1 的最小 x) - (末尾 0 的个数为 k 的最小 x)，这之间的数都保持末尾为 0 的个数为 k 这个特性
        return (int) (help(k + 1) - help(k));
    }

    // 获得末尾0的个数不超过 k 的最小的 x
    long help(int k) {
        long l = 0, r = k * 5L;
        while (l <= r) {
            long mid = (l + r) >>> 1;
            long calc = calc(mid);
            if (calc < k) {
                l = mid + 1;
            } else r = mid - 1;
        }
        return r + 1;
    }

    // 获得 x 的阶乘末尾 0 的个数
    long calc(long x) {
        long res = 0;
        while (x > 0) {
            x /= 5;
            res += x;
        }
        return res;
    }
}