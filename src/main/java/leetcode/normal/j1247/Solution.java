package leetcode.normal.j1247;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-swaps-to-make-strings-equal/">1247. 交换字符使得字符串相同</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumSwap(String s1, String s2) {
        if (s1.length() != s2.length()) return -1;
        int cntX = 0, cntY = 0, cnt0 = 0, cnt1 = 0;
        // 如果存在答案，那么 x 的数量和 y 的数量必须都为偶数，才可以均分 x 和 y
        // 如果在某一个位置 i，使得 s1[i] = s2[i]，那么位置 i 可以不做操作
        // 否则会有两种情况，分别为：
        // 1. s1[i] = 'x' and s2[i] = 'y'
        // 2. s1[i] = 'y' and s2[i] = 'x'
        // 组合起来有四种情况：
        //  1 + 1，即 xx / yy，需要 1 次操作可完成
        //  1 + 2，即 xy / xy，需要 2 次操作可完成
        //  2 + 2，即 yy / xx，需要 1 次操作可完成
        //  2 + 1，即 yx / yx，需要 2 次操作可完成
        // 那么我们贪心的处理 1 + 1 以及 2 + 2 的情况，剩余的就都是 1 + 2 或者 2 + 1 的情况了，可以计算出结果
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i), ch2 = s2.charAt(i);
            cntX += (ch1 == 'x' ? 1 : 0) + (ch2 == 'x' ? 1 : 0);
            cntY += (ch1 == 'y' ? 1 : 0) + (ch2 == 'y' ? 1 : 0);
            cnt0 += (ch1 == 'x' && ch2 == 'y') ? 1 : 0;
            cnt1 += (ch2 == 'x' && ch1 == 'y') ? 1 : 0;
        }
        if ((cntX & 1) == 1 || (cntY & 1) == 1) return -1;
        int ans = (cnt0 >> 1) + (cnt1 >> 1);
        if ((cnt0 & 1) == 1 || (cntY & 1) == 1) ans += 2;
        return ans;
    }
}