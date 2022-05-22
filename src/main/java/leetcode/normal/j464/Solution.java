package leetcode.normal.j464;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/can-i-win/
 * 464. 我能赢吗
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((maxChoosableInteger * (maxChoosableInteger + 1) >> 1) < desiredTotal) return false;
        int maxStat = 1 << maxChoosableInteger;
        Boolean[] visit = new Boolean[maxStat];
        return dfs(desiredTotal, visit, maxStat - 1);
    }

    boolean dfs(int leftTotal, Boolean[] visit, int choosing) {
        if (leftTotal <= 0) return true;
        if (visit[choosing] != null) return visit[choosing];
        boolean res = false;
        for (int cur = choosing, lowBit = choosing & (-choosing); cur != 0; cur -= lowBit, lowBit = cur & (-cur)) {
            int tmp = leftTotal - Integer.bitCount(lowBit - 1) - 1;
            if (tmp <= 0 || !dfs(tmp, visit, choosing ^ lowBit)) {
                res = true;
                break;
            }
        }
        visit[choosing] = res;
        return res;
    }
}