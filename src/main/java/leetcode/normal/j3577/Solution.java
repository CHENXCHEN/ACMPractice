package leetcode.normal.j3577;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-the-number-of-computer-unlocking-permutations/description/">3577. 统计计算机解锁顺序排列数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countPermutations(int[] complexity) {
        // 如果第一个比所有的小，那么可以以任意排列完成解锁
        int n = complexity.length;
        for (int i = 1; i < n; i++) {
            if (complexity[i] <= complexity[0]) return 0;
        }

        int MOD = (int) 1e9 + 7;
        long ans = 1L;
        for (int i = 2; i < n; i++) {
            ans = (ans * i) % MOD;
        }
        return (int) ans;
    }
}