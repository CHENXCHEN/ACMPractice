package leetcode.normal.j3175;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-first-player-to-win-k-games-in-a-row/description/">3175. 找到连续赢 K 场比赛的第一位玩家</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int maxIdx = 0;
        for (int i = 1; i < skills.length; i++) {
            if (skills[maxIdx] < skills[i]) {
                maxIdx = i;
            }
            deque.addLast(i);
        }
        if (k >= skills.length) {
            return maxIdx;
        }
        int cur = 0, lastCnt = 0;
        while (!deque.isEmpty()) {
            Integer top = deque.poll();
            int failed = top;
            if (skills[cur] > skills[top]) {
                ++lastCnt;
            } else {
                failed = cur;
                cur = top;
                lastCnt = 1;
            }
            if (lastCnt >= k) break;
            deque.addLast(failed);
        }
        return cur;
    }
}