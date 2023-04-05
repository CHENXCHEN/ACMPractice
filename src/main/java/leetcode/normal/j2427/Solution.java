package leetcode.normal.j2427;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-common-factors/">2427. 公因子的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int commonFactors(int a, int b) {
        int maxGcd = gcd(a, b);
        int ans = 1;
        for (int i = 2; i <= maxGcd; i++) {
            if (a % i == 0 && b % i == 0) ++ans;
        }
        return ans;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}