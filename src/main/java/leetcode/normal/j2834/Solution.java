package leetcode.normal.j2834;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-minimum-possible-sum-of-a-beautiful-array/description/">2834. 找出美丽数组的最小和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumPossibleSum(int n, int target) {
        int m = target >> 1;
        int mod = (int) 1e9 + 7;
        long ans = 0;
        if (n <= m) {
            ans = (1L + n) * n / 2 % mod;
        } else {
            ans = ((1L + m) * m / 2 + ((long) target + target + (n - m) - 1) * (n - m) / 2) % mod;
        }
        return (int) ans;
    }
}