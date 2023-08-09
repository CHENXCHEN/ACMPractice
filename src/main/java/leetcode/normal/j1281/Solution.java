package leetcode.normal.j1281;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/subtract-the-product-and-sum-of-digits-of-an-integer/">1281. 整数的各位积和之差</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int subtractProductAndSum(int n) {
        int mul = 1, sum = 0;
        while (n > 0) {
            int mod = n % 10;
            mul *= mod;
            sum += mod;
            n /= 10;
        }
        return mul - sum;
    }
}