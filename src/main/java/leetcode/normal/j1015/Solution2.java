package leetcode.normal.j1015;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/smallest-integer-divisible-by-k/">1015. 可被 K 整除的最小整数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int smallestRepunitDivByK(int k) {
        // 显然，如果 k 有因数 2 / 5 / 10 的话，一定没有解
        if (k % 2 == 0 || k % 5 == 0) return -1;
        // 否则一定有解
        int ans = 1, cur = 1;
        while (cur % k != 0) {
            ++ans;
            cur = (cur * 10 + 1) % k;
        }
        return ans;
    }
}