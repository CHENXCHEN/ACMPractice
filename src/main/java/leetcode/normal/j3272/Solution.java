package leetcode.normal.j3272;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-count-of-good-integers/description/">3272. 统计好整数的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long countGoodIntegers(int n, int k) {
        Set<String> dict = new HashSet<>();
        // 只需要枚举回文串的左半边就行，这里需要考虑：
        // 1. 不能以0开始
        // 2. 如果是奇数时，反转需要跳过一位
        int base = (int) Math.pow(10, (n - 1) / 2);
        int skip = n & 1;
        for (int i = base; i < base * 10; i++) {
            String s = String.valueOf(i);
            s += new StringBuilder(s).reverse().substring(skip);
            long pInt = Long.parseLong(s);
            if (pInt % k == 0) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                dict.add(new String(chars));
            }
        }

        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        long ans = 0;
        for (String s : dict) {
            int[] cnt = new int[10];
            for (char c : s.toCharArray()) {
                cnt[c - '0']++;
            }
            // 计算排列组合
            // 0不能放在首位，所以 0 可以放在除了首位的任意位置，就有 (n - cnt[0]) * fact[n - 1] 的排列组合
            long tot = (n - cnt[0]) * fact[n - 1];
            // 再排除掉相同数字重复的情况，除了 0 以外的字符都有 C(n-c[0], c[i]) 的组合数，即除了 c[0] 放的位置以外的其他位置
            for (int x : cnt) {
                tot /= fact[x];
            }
            ans += tot;
        }
        return ans;
    }
}