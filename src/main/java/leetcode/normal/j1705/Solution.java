package leetcode.normal.j1705;

import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-number-of-eaten-apples/description/">1705. 吃苹果的最大数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int eatenApples(int[] apples, int[] days) {
        // 优先吃快腐烂的苹果
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        int i = 0, n = apples.length, ans = 0;
        while (i < n) {
            // 把所有已经腐烂的都扔掉
            while (!pq.isEmpty() && pq.peek()[0] <= i) pq.poll();
            int maxDay = i + days[i], leftApple = apples[i];
            if (leftApple > 0) pq.add(new int[]{maxDay, leftApple});
            if (!pq.isEmpty()) {
                int[] cur = pq.peek();
                cur[1]--;
                if (cur[1] == 0) pq.poll();
                ans++;
            }
            i++;
        }
        while (!pq.isEmpty()) {
            while (!pq.isEmpty() && pq.peek()[0] <= i) pq.poll();
            if (pq.isEmpty()) break;
            int[] cur = pq.poll();
            // 最多可以吃多少个
            int canEat = Math.min(cur[0] - i, cur[1]);
            ans += canEat;
            i += canEat;
        }
        return ans;
    }
}