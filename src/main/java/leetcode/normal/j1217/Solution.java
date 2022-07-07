package leetcode.normal.j1217;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-cost-to-move-chips-to-the-same-position/">1217. 玩筹码</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minCostToMoveChips(int[] position) {
        int[] cnts = {0, 0};
        for (int i : position) {
            cnts[i % 2]++;
        }
        return Math.min(cnts[0], cnts[1]);
    }
}