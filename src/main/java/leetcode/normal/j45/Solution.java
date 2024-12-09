package leetcode.normal.j45;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/jump-game-ii/description/">45. 跳跃游戏 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] minStep = new int[n];
        Arrays.fill(minStep, -1);
        minStep[0] = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        while (!deque.isEmpty()) {
            Integer cur = deque.poll();
            for (int i = 1; i <= nums[cur] && cur + i < n; i++) {
                int next = cur + i;
                if (minStep[next] == -1 || minStep[cur] + 1 < minStep[next]) {
                    minStep[next] = minStep[cur] + 1;
                    deque.add(next);
                }
            }
        }
        return minStep[n - 1];
    }
}