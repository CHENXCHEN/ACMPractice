package leetcode.normal.j1654;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-jumps-to-reach-home/">1654. 到家的最少跳跃次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Queue<int[]> queue = new ArrayDeque<int[]>();
        Set<Integer> visited = new HashSet<Integer>();
        queue.offer(new int[]{0, 1, 0});
        visited.add(0);
        int lower = 0, upper = Math.max(Arrays.stream(forbidden).max().getAsInt() + a, x) + b;
        Set<Integer> forbiddenSet = new HashSet<Integer>();
        for (int position : forbidden) {
            forbiddenSet.add(position);
        }
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int position = arr[0], direction = arr[1], step = arr[2];
            if (position == x) {
                return step;
            }
            int nextPosition = position + a;
            int nextDirection = 1;
            if (lower <= nextPosition && nextPosition <= upper && !visited.contains(nextPosition * nextDirection) && !forbiddenSet.contains(nextPosition)) {
                visited.add(nextPosition * nextDirection);
                queue.offer(new int[]{nextPosition, nextDirection, step + 1});
            }
            if (direction == 1) {
                nextPosition = position - b;
                nextDirection = -1;
                if (lower <= nextPosition && nextPosition <= upper && !visited.contains(nextPosition * nextDirection) && !forbiddenSet.contains(nextPosition)) {
                    visited.add(nextPosition * nextDirection);
                    queue.offer(new int[]{nextPosition, nextDirection, step + 1});
                }
            }
        }
        return -1;
    }
}
