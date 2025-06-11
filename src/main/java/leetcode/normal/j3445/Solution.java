package leetcode.normal.j3445;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-difference-between-even-and-odd-frequency-ii/description/">3445. 奇偶频次间的最大差值 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxDifference(String s, int k) {
        int n = s.length();
        int ans = Integer.MIN_VALUE;
        for (char a = '0'; a <= '4'; a++) {
            for (char b = '0'; b <= '4'; b++) {
                if (a == b) continue;
                int[] best = new int[4];
                Arrays.fill(best, Integer.MAX_VALUE);
                // cntA：[0,right] 区间内，字符 a 出现的次数
                // cntB: [0,right] 区间内，字符 b 出现的次数
                // preA: [0,left] 区间内，字符 a 出现的次数
                // preB: [0,left] 区间内，字符 b 出现的次数
                // 令 (left,right] 为其中一个连续子区间，那么这个区间的答案为
                //      (cntA - preA) - (cntB - preB)
                //      (cntA - cntB) - (preA - preB)
                // 如果要求子区间的最大值，则应该是 cntA - cntB - min(preA - preB)
                // 需要满足两个条件：
                //      1. right - left >= k，至少保证长度为 k
                //      2. cntB - preB >= 2，至少保证 b 字符出现的次数为偶数
                int cntA = 0, cntB = 0;
                int preA = 0, preB = 0;
                int left = -1;
                for (int right = 0; right < n; right++) {
                    cntA += (s.charAt(right) == a) ? 1 : 0;
                    cntB += (s.charAt(right) == b) ? 1 : 0;
                    while (right - left >= k && cntB - preB >= 2) {
                        int leftStatus = getStatus(preA, preB);
                        best[leftStatus] = Math.min(best[leftStatus], preA - preB);
                        ++left;
                        preA += (s.charAt(left) == a) ? 1 : 0;
                        preB += (s.charAt(left) == b) ? 1 : 0;
                    }
                    int rightStatus = getStatus(cntA, cntB);
                    // 不管当前 cntA 与 cntB 的奇偶性，只要满足：
                    // cntA - preA 是奇数
                    // cntB - preB 是偶数
                    if (best[rightStatus ^ 0b10] != Integer.MAX_VALUE) {
                        ans = Math.max(ans, cntA - cntB - best[rightStatus ^ 0b10]);
                    }
                }
            }
        }
        return ans;
    }

    int getStatus(int cntA, int cntB) {
        return ((cntA & 1) << 1) | (cntB & 1);
    }
}