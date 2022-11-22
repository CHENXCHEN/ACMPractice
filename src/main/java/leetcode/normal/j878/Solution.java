package leetcode.normal.j878;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/nth-magical-number/">878. 第 N 个神奇数字</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        int MOD = 1000000007;
        long left = Math.min(a, b), right = (long) n * left, ans = 0;
        int comm = lcm(a, b);
        while (left <= right) {
            long mid = (left + right) >> 1;
            long cur = mid / a + mid / b - mid / comm;
            if (cur == n) {
                ans = mid;
                right = mid - 1;
            } else if (cur < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) (ans % MOD);
    }

    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}