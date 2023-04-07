package leetcode.normal.j1040;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/moving-stones-until-consecutive-ii/">1040. 移动石子直到连续 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;
        int[] ans = new int[2];
        if (stones[n - 1] - stones[0] + 1 == n) return ans;
        // 将最左边移到临近的点后，存在轮流移动不会损失空位
        // 将最右边移到临近的点后，存在轮聊移动不会损失空位
        // 比较这两个可以获得操作最大数
        ans[1] = Math.max(stones[n - 1] - stones[1] + 1, stones[n - 2] - stones[0] + 1) - (n - 1);
        ans[0] = n;
        for (int i = 0, j = 0; i < n && j + 1 < n; i++) {
            // 找到以 i 开始，长度为 n 的区间，包含的石子数
            while (j + 1 < n && stones[j + 1] - stones[i] + 1 <= n) {
                ++j;
            }
            if (j - i + 1 == n - 1 && stones[j] - stones[i] + 1 == n - 1) {
                ans[0] = Math.min(ans[0], 2);
            } else {
                ans[0] = Math.min(ans[0], n - (j - i + 1));
            }
        }
        return ans;
    }
}