package leetcode.normal.j1599;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-profit-of-operating-a-centennial-wheel/">1599. 经营摩天轮的最大利润</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int ans = 0, ansCnt = -1, onBoardCnt = 0, onRunCnt = 0, onWaitCnt = 0;
        for (int i = 0; i < customers.length; i++) {
            ++onRunCnt;
            onWaitCnt += customers[i];
            int removeCnt = Math.min(onWaitCnt, 4);
            onWaitCnt -= removeCnt;
            onBoardCnt += removeCnt;
            int curAns = onBoardCnt * boardingCost - runningCost * onRunCnt;
            if (curAns > ans) {
                ans = curAns;
                ansCnt = onRunCnt;
            }
        }
        if (onWaitCnt > 0) {
            int runCnt = onWaitCnt / 4;
            if (runCnt > 0) {
                onWaitCnt -= runCnt << 2;
                onBoardCnt += runCnt << 2;
                onRunCnt += runCnt;
                int curAns = onBoardCnt * boardingCost - runningCost * onRunCnt;
                if (curAns > ans) {
                    ans = curAns;
                    ansCnt = onRunCnt;
                }
            }
            if (onWaitCnt > 0) {
                onBoardCnt += onWaitCnt;
                onRunCnt += 1;
                int curAns1 = onBoardCnt * boardingCost - runningCost * onRunCnt;
                if (curAns1 > ans) {
                    ans = curAns1;
                    ansCnt = onRunCnt;
                }
            }
        }
        return ansCnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {8, 3};
        solution.minOperationsMaxProfit(arr, 5, 6);
    }
}