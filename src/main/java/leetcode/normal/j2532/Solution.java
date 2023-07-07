package leetcode.normal.j2532;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/time-to-cross-a-bridge/">2532. 过桥的时间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        // time[i] = [leftToRight_i, pickOld_i, rightToLeft_i, putNew_i]
        // 效率比较器，效率低的优先出
        Comparator<Integer> waitCmp = (x, y) -> {
            // 比较工作效率，leftToRight + rightToLeft，时间大的效率低
            // 如果相等，那么下标大的效率低
            int timeX = time[x][0] + time[x][2];
            int timeY = time[y][0] + time[y][2];
            return timeX != timeY ? timeY - timeX : y - x;
        };
        PriorityQueue<Integer>
                waitLeft = new PriorityQueue<>(waitCmp),
                waitRight = new PriorityQueue<>(waitCmp);
        Comparator<int[]> workCmp = (x, y) -> {
            // x[0] 表示当前完成工作的时间，x[1] 表示当前的工人编号
            // 比较谁先完成，如果相等，那么下标小的先完成
            return x[0] != y[0] ? x[0] - y[0] : x[1] - y[1];
        };
        PriorityQueue<int[]>
                workLeft = new PriorityQueue<>(workCmp),
                workRight = new PriorityQueue<>(workCmp);
        int remain = n, curTime = 0;
        for (int i = 0; i < k; i++) {
            waitLeft.add(i);
        }
        while (remain > 0 || !workRight.isEmpty() || !waitRight.isEmpty()) {
            // 1. 若 workLeft / workRight 中的工人完成工作，则将它们去除，并放置到 waitLeft / waitRight
            while (!workLeft.isEmpty() && workLeft.peek()[0] <= curTime) {
                waitLeft.add(workLeft.poll()[1]);
            }
            while (!workRight.isEmpty() && workRight.peek()[0] <= curTime) {
                waitRight.add(workRight.poll()[1]);
            }

            if (!waitRight.isEmpty()) {
                // 2. 若右侧有工人在等，那么取出优先级最低的工人并过桥
                int id = waitRight.poll();
                // 当前工人要从右边到左边过桥，加上过桥时间
                curTime += time[id][2];
                // 当前工人在左边完成工作的时间
                workLeft.add(new int[]{curTime + time[id][3], id});
            } else if (remain > 0 && !waitLeft.isEmpty()) {
                // 3. 若右侧还有箱子，并且左侧有工人在等待，则去除优先级最低的工人过桥
                int id = waitLeft.poll();
                // 当前工人要从左边到右边过桥，加上过桥时间
                curTime += time[id][0];
                // 当前工人在右边完成工作的时间
                workRight.add(new int[]{curTime + time[id][1], id});
                remain--;
            } else {
                // 4. 否则，没有人需要过桥，时间过渡到 workLeft 和 workRight 中最早完成时间
                int nextTime = Integer.MAX_VALUE;
                if (!workLeft.isEmpty()) {
                    nextTime = Math.min(nextTime, workLeft.peek()[0]);
                }
                if (!workRight.isEmpty()) {
                    nextTime = Math.min(nextTime, workRight.peek()[0]);
                }
                if (nextTime != Integer.MAX_VALUE) {
                    curTime = Math.max(nextTime, curTime);
                }
            }
        }
        return curTime;
    }
}