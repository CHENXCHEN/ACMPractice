package leetcode.normal.j1792;

import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-average-pass-ratio/description/">1792. 最大平均通过率</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // 求加入额外学生后的最大的平均通过率
        // 假定 b 为通过的学生，a 这个班级的人数
        // 那么没增加1人通过，增加的通过率为 (a+1) / (b+1) - a / b，我们需要尽可能的增加通过率，因此每次都把一个人放到加了之后最大通过率的那个班级
        // (a+1) / (b+1) - a / b => (a - b) / (a * (a + 1))
        // 我们需要按照通过率来进行排序，(a0 - b0) / (a0 * (a0 + 1)) 与 (a1 - b1) / (a1 * (a1 + 1)) 进行比较，取较大值
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> {
            long a0 = classes[x][1], b0 = classes[x][0], a1 = classes[y][1], b1 = classes[y][0];
            long val1 = (a1 - b1) * a0 * (a0 + 1), val2 = (a0 - b0) * a1 * (a1 + 1);
            return Long.compare(val1, val2);
        });
        for (int i = 0; i < classes.length; i++) pq.add(i);
        for (int i = 0; i < extraStudents; i++) {
            Integer cur = pq.poll();
            classes[cur][0]++;
            classes[cur][1]++;
            pq.add(cur);
        }
        double ans = 0;
        for (int[] aClass : classes) {
            ans += 1.0 * aClass[0] / aClass[1];
        }
        return ans / classes.length;
    }
}