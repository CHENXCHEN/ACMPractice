package leetcode.normal.j3100;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/water-bottles-ii/description/">3100. 换水问题 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int emptyBottles = numBottles, ans = numBottles;
        numBottles = 0;
        while (emptyBottles >= numExchange) {
            numBottles++;
            emptyBottles += numBottles;
            emptyBottles -= numExchange;
            ans += numBottles;

            numBottles = 0;
            ++numExchange;
        }
        return ans;
    }
}