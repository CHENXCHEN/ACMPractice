package leetcode.normal.j3175;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-first-player-to-win-k-games-in-a-row/description/">3175. 找到连续赢 K 场比赛的第一位玩家</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int findWinningPlayer(int[] skills, int k) {
        int cur = 0, lastCnt = 0, maxIdx = 0;
        for (int i = 1; i < skills.length; i++) {
            if (skills[i] > skills[maxIdx]) maxIdx = i;
            if (skills[i] < skills[cur]) {
                lastCnt++;
            } else {
                cur = i;
                lastCnt = 1;
            }
            if (lastCnt >= k) return cur;
        }
        return maxIdx;
    }
}