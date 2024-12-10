package leetcode.normal.j1306;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/jump-game-iii/description/">1306. 跳跃游戏 III</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        visited[start] = true;
        deque.add(start);
        while (!deque.isEmpty()) {
            Integer cur = deque.poll();
            if (arr[cur] == 0) return true;
            if (cur + arr[cur] < n && !visited[cur + arr[cur]]) {
                visited[cur + arr[cur]] = true;
                deque.add(cur + arr[cur]);
            }
            if (cur - arr[cur] >= 0 && !visited[cur - arr[cur]]) {
                visited[cur - arr[cur]] = true;
                deque.add(cur - arr[cur]);
            }
        }
        return false;
    }
}