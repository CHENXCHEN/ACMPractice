package leetcode.normal.j2413;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/smallest-even-multiple/">2413. 最小偶倍数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int smallestEvenMultiple(int n) {
        return 2 * n / gcd(2, n);
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}