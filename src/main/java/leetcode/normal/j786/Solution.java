package leetcode.normal.j786;

import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/k-th-smallest-prime-fraction/
 * 786. 第 K 个最小的素数分数
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pQueue = new PriorityQueue<>((x, y) -> arr[x[0]] * arr[y[1]] - arr[y[0]] * arr[x[1]]);
        for (int i = 1; i < arr.length; i++) {
            pQueue.offer(new int[]{0, i});
        }
        for (int i = 1; i < k; i++) {
            int[] poll = pQueue.poll();
            if (poll[0] + 1 < poll[1]) {
                pQueue.offer(new int[]{poll[0] + 1, poll[1]});
            }
        }
        return new int[]{arr[pQueue.peek()[0]], arr[pQueue.peek()[1]]};
    }
}