package leetcode.normal.j1109;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/corporate-flight-bookings/
 * 1109. 航班预订统计
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] accArr = new int[n + 2];
        Arrays.fill(accArr, 0);
        for (int[] bk : bookings) {
            accArr[bk[0]] += bk[2];
            accArr[bk[1] + 1] -= bk[2];
        }
        int[] ans = new int[n];
        int s = 0;
        for (int i = 0; i < n; i++) {
            s += accArr[i + 1];
            ans[i] = s;
        }
        return ans;
    }
}