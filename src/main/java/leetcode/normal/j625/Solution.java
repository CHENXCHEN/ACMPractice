package leetcode.normal.j625;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-factorization/description/">625. 最小因式分解</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int smallestFactorization(int num) {
        if (num == 1) return 1;
        int[] cnt = new int[10];
        int res = num;
        for (int i = 9; i >= 2; i--) {
            while (res > 0 && res % i == 0) {
                res /= i;
                ++cnt[i];
            }
        }
        int all = Arrays.stream(cnt).sum();
        if (all > 10) return 0;
        long ans = 0;
        for (int i = 2; i < 10; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                ans = ans * 10 + i;
            }
        }
        return res == 1 && ans <= Integer.MAX_VALUE ? (int) ans : 0;
    }
}