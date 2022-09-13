package leetcode.normal.j857;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-cost-to-hire-k-workers/">857. 雇佣 K 名工人的最低成本</a>
 * 假定选定了 k 个员工，分别为 h[0]...h[k-1]，
 * 那么对于每个员工必须要满足 totalC * quality[h[i]] / totalQuality >= wage[h[i]]
 * 转换后可得 totalC >= totalQuality * wage[h[i]] / quality[h[i]]
 * 最低价格由 Max(wage[h[i]] / quality[h[i]]) 决定，那么可以贪心枚举每一个为最大值时，计算 totalC 的值，取最小值即可
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] h = new Integer[n];
        for (int i = 0; i < n; i++) h[i] = i;
        Arrays.sort(h, (a, b) -> wage[a] * quality[b] - wage[b] * quality[a]);
        int totalQuality = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k - 1; i++) {
            totalQuality += quality[h[i]];
            priorityQueue.add(quality[h[i]]);
        }
        double ans = 1e9;
        for (int i = k - 1; i < n; i++) {
            int idx = h[i];
            totalQuality += quality[idx];
            priorityQueue.add(quality[idx]);
            double totalCal = ((double) wage[idx] / quality[idx]) * totalQuality;
            ans = Math.min(ans, totalCal);
            totalQuality -= priorityQueue.poll();
        }
        return ans;
    }
}