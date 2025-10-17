package leetcode.normal.j3003;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximize-the-number-of-partitions-after-operations/description/">3003. 执行操作后的最大分割数量</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxPartitionsAfterOperations(String s, int k) {
        int n = s.length();
        // 不修改的情况下，节点往前、后的 段数、掩码、长度
        int[][] left = new int[n][3];
        int[][] right = new int[n][3];

        int num = 0, mask = 0, cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            int cur = 1 << (s.charAt(i) - 'a');
            if ((mask & cur) == 0) {
                ++cnt;
                if (cnt <= k) {
                    mask |= cur;
                } else {
                    num++;
                    mask = cur;
                    cnt = 1;
                }
            }
            left[i + 1][0] = num;
            left[i + 1][1] = mask;
            left[i + 1][2] = cnt;
        }
        num = 0;
        mask = 0;
        cnt = 0;
        for (int i = n - 1; i > 0; i--) {
            int cur = 1 << (s.charAt(i) - 'a');
            if ((mask & cur) == 0) {
                ++cnt;
                if (cnt <= k) {
                    mask |= cur;
                } else {
                    num++;
                    mask = cur;
                    cnt = 1;
                }
            }
            right[i - 1][0] = num;
            right[i - 1][1] = mask;
            right[i - 1][2] = cnt;
        }

        int maxVal = 0;
        // 枚举修改每一位带来的影响
        for (int i = 0; i < n; i++) {
            int seg = left[i][0] + right[i][0] + 2;
            int totMask = left[i][1] | right[i][1];
            int totCnt = Integer.bitCount(totMask);
            // 最多可以包含k种字符，而不是长度为k
            if (left[i][2] == k && right[i][2] == k && totCnt < 26) {
                ++seg;
            } else if (Math.min(totCnt + 1, 26) <= k) {
                --seg;
            }
            maxVal = Math.max(maxVal, seg);
        }
        return maxVal;
    }
}