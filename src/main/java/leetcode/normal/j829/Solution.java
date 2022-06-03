package leetcode.normal.j829;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/consecutive-numbers-sum/
 * 829. 连续整数求和
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int consecutiveNumbersSum(int n) {
        int bound = n << 1;
        int ans = 0;
        for (int k = 1; k * (k + 1) <= bound; k++) {
            if (isKCon(n, k)) ans++;
        }
        return ans;
    }

    boolean isKCon(int n, int k) {
        // n = k * (2 * x + k - 1) / 2
        if ((k & 1) == 1) {
            // n / k - (k - 1) / 2 = x
            // 求 x 为整数时，必须是 n / k 为整数且 (k - 1) / 2 为整数
            return n % k == 0;
        } else {
            // (2x + k - 1) / 2 = n / k
            // 这种情况下 n % k 一定不为整数，且 2n / k 为整数的时候，有解
            return n % k != 0 && (n << 1) % k == 0;
        }
    }
}