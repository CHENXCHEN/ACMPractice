package leetcode.normal.j1494;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/parallel-courses-ii/">1494. 并行课程 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        // i 为已经选择 n 门课的状态压缩
        // dp[i] 为学习了这些课程(i)的最小学期数
        // need[i] 为学习这些课程(i)所需要的前置课程
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int[] need = new int[1 << n];
        for (int[] relation : relations) {
            int u = relation[0] - 1, v = relation[1] - 1;
            need[1 << v] |= 1 << u;
        }
        dp[0] = 0;
        for (int i = 1; i < (1 << n); i++) {
            // 当前已经学习了课程 i
            // i & (i - 1) => 去掉最后一个 1
            // i & -i => 保留最后一个 1
            // 课程 i 需要的课程为 子集需要的 + 补集(i-子集)需要的
            need[i] = need[i & (i - 1)] | need[i & -i];
            // 如果课程 i 需要的前置课程没有完成学习，就跳过
            if ((need[i] | i) != i) {
                continue;
            }
            // 当前学期可以进行学习的课程，除去前置已经学习的课程后，哪些可以学
            int valid = i ^ need[i];
            if (Integer.bitCount(valid) <= k) {
                // 如果可以学习的课程数量小于 k，则可以全部学习，不用枚举子集
                dp[i] = Math.min(dp[i], dp[i ^ valid] + 1);
            } else {
                // 枚举当前学期需要进行学习的课程集合
                for (int sub = valid; sub > 0; sub = (sub - 1) & valid) {
                    if (Integer.bitCount(sub) <= k) {
                        dp[i] = Math.min(dp[i], dp[i ^ sub] + 1);
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}