package leetcode.week.j295.j6080;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/longest-increasing-subsequence/
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int totalSteps(int[] nums) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        // 第 i 个数需要 cost[i] 轮操作才能删除
        int[] cost = new int[nums.length];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int nowRound = 0;
            // 从单调栈中去掉小于 num[i] 的所有数，直到遇到 大于 num[j] > num[i] 为止，此时 j < i
            // 那么 num[i] 如果需要删除的话，需要找到 j < k < i，max(cost[k]) + 1 就为 num[i] 需要被删除的轮操作数
            // 对于 j < k < k+x < i，如果 num[k] <= num[k+x]，那么必然有 cost[k] < cost[k+x]，因此我们只需要保留非递减序列的最后一个元素即可，其他的都踢出去
            while (!deque.isEmpty() && nums[deque.peek()] <= nums[i]) {
                nowRound = Math.max(nowRound, cost[deque.peek()]);
                deque.pop();
            }
            // 如果单调栈为空了的话，那么说明 num[i] 永远不会被删除，也无需去更新 cost[i] 的值
            if (!deque.isEmpty()) {
                cost[i] = ++nowRound;
                ans = Math.max(ans, nowRound);
            }
            deque.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1682, 63, 124, 147, 897, 1210, 1585, 1744, 1764, 1945, 323, 984, 1886, 346, 481, 1059, 1388, 1483, 1516, 1842, 1868, 1877, 504, 1197, 785, 955, 970, 1848, 1851, 398, 907, 995, 1167, 1214, 1423, 1452, 1464, 1474, 1311, 1427, 1757, 1992, 57, 1625, 1260, 700, 725};
        System.out.println(solution.totalSteps(nums));
    }
}
