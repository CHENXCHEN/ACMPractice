package leetcode.normal.j2931;

import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-spending-after-buying-items/description/">2931. 购买物品的最大开销</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long maxSpending(int[][] values) {
        // 贪心，每次取最外层最小的，最后总和一定最大
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        int rows = values.length, cols = values[0].length;
        for (int i = 0; i < rows; i++)
            pq.offer(new int[]{values[i][cols - 1], i, cols - 1});

        int tot = rows * cols;
        long ans = 0;
        for (int turn = 1; turn <= tot; turn++) {
            int[] cur = pq.poll();
            int x = cur[1], y = cur[2];
            ans += (long) turn * cur[0];
            if (y > 0) {
                pq.offer(new int[]{values[x][y - 1], x, y - 1});
            }
        }
        return ans;
    }
}