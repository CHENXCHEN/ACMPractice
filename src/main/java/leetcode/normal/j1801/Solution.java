package leetcode.normal.j1801;

import javafx.util.Pair;

import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-orders-in-the-backlog/">1801. 积压订单中的订单总数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<Pair<Integer, Integer>> buyQueue = new PriorityQueue<>((x, y) -> y.getKey() - x.getKey());
        PriorityQueue<Pair<Integer, Integer>> sellQueue = new PriorityQueue<>((x, y) -> x.getKey() - y.getKey());
        long mod = 1000000000 + 7;
        for (int[] order : orders) {
            int price = order[0], cnt = order[1];
            if (order[2] == 0) {
                // buy
                while (!sellQueue.isEmpty() && sellQueue.peek().getKey() <= price && cnt > 0) {
                    Pair<Integer, Integer> sell = sellQueue.poll();
                    int removeCnt = Math.min(sell.getValue(), cnt);
                    cnt -= removeCnt;
                    if (sell.getValue() > removeCnt) {
                        sellQueue.add(new Pair<>(sell.getKey(), sell.getValue() - removeCnt));
                    }
                }
                if (cnt > 0) {
                    buyQueue.add(new Pair<>(price, cnt));
                }
            } else {
                // sell
                while (!buyQueue.isEmpty() && buyQueue.peek().getKey() >= price && cnt > 0) {
                    Pair<Integer, Integer> buy = buyQueue.poll();
                    int removeCnt = Math.min(buy.getValue(), cnt);
                    cnt -= removeCnt;
                    if (buy.getValue() > removeCnt) {
                        buyQueue.add(new Pair<>(buy.getKey(), buy.getValue() - removeCnt));
                    }
                }
                if (cnt > 0) {
                    sellQueue.add(new Pair<>(price, cnt));
                }
            }
        }
        long ans = 0L;
        while (!buyQueue.isEmpty()) {
            ans = (ans + buyQueue.poll().getValue()) % mod;
        }
        while (!sellQueue.isEmpty()) {
            ans = (ans + sellQueue.poll().getValue()) % mod;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{16, 24, 0}, {16, 2, 1}, {23, 28, 1}, {21, 6, 0}, {17, 8, 0}, {25, 7, 0}};
        Solution solution = new Solution();
        solution.getNumberOfBacklogOrders(arr);
    }
}