package leetcode.normal.j2438;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/range-product-queries-of-powers/description/">2438. 二的幂数组中查询范围内的乘积</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int MOD = (int) 1e9 + 7;

    public int[] productQueries(int n, int[][] queries) {
        ArrayList<Integer> list = new ArrayList<>();
        while (n > 0) {
            int x = n & -n;
            list.add(Integer.numberOfTrailingZeros(x));
            n -= x;
        }
        int[] preSum = new int[list.size() + 1];
        for (int i = 0; i < list.size(); i++) {
            preSum[i + 1] = preSum[i] + list.get(i);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int t = preSum[queries[i][1] + 1] - preSum[queries[i][0]];
            ans[i] = (int) (fastPow(2, t) % MOD);
        }
        return ans;
    }

    long fastPow(long x, int n) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = (res * x) % MOD;
            }
            x = (x * x) % MOD;
            n >>= 1;
        }
        return res;
    }

}