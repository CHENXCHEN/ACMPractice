package leetcode.normal.j2412;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-money-required-before-transactions/description/">2412. 完成所有交易的初始最少钱数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long minimumMoney(int[][] transactions) {
        ArrayList<int[]> filtered = new ArrayList<>();
        // 最坏的情况一定是先进行亏损交易，再进行盈利交易
        // 最后一笔交易有两种情况：亏损和盈利
        // 若最后一笔为赚钱，那么初始资金应该为 totLose + cost
        //      如果是赚钱，那么 cost < cashback，cost 是最小值
        // 若最后一笔为亏损，那么初始资金应该为 totLose + cashback = totLose - (cost - cashback) + cost
        //      如果是亏损，那么 cost > cashback，cashback 是最小值
        long totLose = 0;
        int res = 0;
        for (int[] transaction : transactions) {
            int cost = transaction[0], cashback = transaction[1];
            totLose += Math.max(cost - cashback, 0);
            res = Math.max(res, Math.min(cost, cashback));
        }
        return totLose + res;
    }
}