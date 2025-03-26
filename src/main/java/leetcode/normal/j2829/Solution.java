package leetcode.normal.j2829;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/determine-the-minimum-sum-of-a-k-avoiding-array/description/">2829. k-avoiding 数组的最小总和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumSum(int n, int k) {
        if (n <= k / 2) return sum(1, 1, n);
        else return sum(1, 1, k / 2) + sum(k, 1, n - k / 2);
    }

    int sum(int a1, int d, int n) {
        return (a1 + a1 + (n - 1) * d) * n / 2;
    }
}