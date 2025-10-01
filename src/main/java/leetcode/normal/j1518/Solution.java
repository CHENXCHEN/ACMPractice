package leetcode.normal.j1518;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/water-bottles/description/">1518. 换水问题</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0, emptyBottles = 0;
        while (numBottles > 0) {
            int round = numBottles / numExchange;
            if (round > 0) {
                ans += round * numExchange;
                numBottles -= round * numExchange;
                emptyBottles += round * numExchange;
            } else {
                ans += numBottles;
                emptyBottles += numBottles;
                numBottles = 0;
            }
            if (emptyBottles >= numBottles) {
                int cnt = emptyBottles / numExchange;
                numBottles += cnt;
                emptyBottles -= cnt * numExchange;
            }
        }
        return ans;
    }
}