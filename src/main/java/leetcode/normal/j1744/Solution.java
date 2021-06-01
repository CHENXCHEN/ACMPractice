package leetcode.normal.j1744;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/
 * 1744. 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] preSum = new long[candiesCount.length + 1];
        for (int i = 0; i < candiesCount.length; i++) preSum[i + 1] = preSum[i] + candiesCount[i];
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int fType = queries[i][0];
            long fDay = queries[i][1];
            long fCap = queries[i][2];
            long x1 = fDay + 1;
            long y1 = fCap * x1;
            long x2 = preSum[fType] + 1L;
            long y2 = preSum[fType + 1];
            // (x1, y1) (x2, y2)
            ans[i] = !(x1 > y2 || y1 < x2);
        }
        return ans;
    }
}
