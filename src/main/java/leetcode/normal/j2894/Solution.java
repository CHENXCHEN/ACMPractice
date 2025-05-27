package leetcode.normal.j2894;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/divisible-and-non-divisible-sums-difference/description/">2894. 分类求和并作差</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int differenceOfSums(int n, int m) {
        int res1 = 0, res2 = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                res2 += i;
            } else {
                res1 += i;
            }
        }
        return res1 - res2;
    }
}