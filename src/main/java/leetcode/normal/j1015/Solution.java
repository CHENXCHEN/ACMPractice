package leetcode.normal.j1015;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/smallest-integer-divisible-by-k/">1015. 可被 K 整除的最小整数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int smallestRepunitDivByK(int k) {
        long cur = 1;
        for (int i = 1; i <= 100000; i++) {
            if (cur % k == 0) return i;
            cur = (cur * 10 + 1) % k;
        }
        return -1;
    }
}