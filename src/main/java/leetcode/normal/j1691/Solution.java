package leetcode.normal.j1691;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-height-by-stacking-cuboids/">1691. 堆叠长方体的最大高度</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxHeight(int[][] cuboids) {
        // 如果 A: a0,a1,a2 可以放在 B: b1,b2,b3 上，那么排序过后，依然也可以堆叠
        // 不失通用性的假设我们有：
        // 数组A: a1 < a2 < ... < an-1 < an
        // 数组B: b1 , b2 , ... , bn-1 , bn
        // 且我们有 ai < bi，但是数组 b 的排序状况未知
        // 对于任意的 bj 和 bk，如果 j < k 并且 bj > bk，那么它们进行交换之后，不会改变其对应位置的性质
        // 也就是说，在右边比较小的数字，可以跟左边比较小的数字进行交换，交换之后，ai < bi 依然成立
        for (int[] cuboid : cuboids) Arrays.sort(cuboid);
        // 如果我们需要进行动态规划，那么我们必须得确保遍历时具备这样的拓扑：当遍历到 i 时，所有能放在 i 之上的情况都遍历过了
        // 按照升序来排序，那么对于 < i 的方块，组合之后可能可以放在 i 之上；对于 > i 的方块，一定不可能放在 i 之上
        // 如果 A 可以放在 B 上，那么 ai <= bi 一定成立，那么 sum(A) < sum(B) 也一定成立
        Arrays.sort(cuboids, (x, y) -> x[0] + x[1] + x[2] - y[0] - y[1] - y[2]);
        int n = cuboids.length, ans = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = cuboids[i][2];
            for (int j = 0; j < i; j++) {
                if (cuboids[i][0] >= cuboids[j][0] && cuboids[i][1] >= cuboids[j][1] && cuboids[i][2] >= cuboids[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}