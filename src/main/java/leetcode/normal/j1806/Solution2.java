package leetcode.normal.j1806;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-operations-to-reinitialize-a-permutation/">1806. 还原排列的最少操作步数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {

    public int reinitializePermutation(int n) {
        boolean[] visit = new boolean[n];
        int ans = 1;
        // 求出若干个互不相交的置换周期的最小公倍数，就是答案
        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            int next = i;
            int len = 0;
            do {
                len++;
                visit[next] = true;
                next = (next & 1) == 0 ? next >> 1 : (n >> 1) + ((next - 1) >> 1);
            } while (!visit[next]);
            ans = lcm(ans, len);
        }
        return ans;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}