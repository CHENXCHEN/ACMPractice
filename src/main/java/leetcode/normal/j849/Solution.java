package leetcode.normal.j849;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximize-distance-to-closest-person/">849. 到最近的人的最大距离</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxDistToClosest(int[] seats) {
        int[] rightPos = new int[seats.length + 1];
        int n = seats.length;
        rightPos[n] = n;
        for (int i = n - 1; i >= 0; i--) {
            if (seats[i] == 1) rightPos[i] = i;
            else rightPos[i] = rightPos[i + 1];
        }
        int ans = 0, leftPos = -1;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                leftPos = i;
                continue;
            }
            int res = Integer.MAX_VALUE;
            if (leftPos != -1) {
                res = i - leftPos;
            }
            if (rightPos[i] != n) {
                res = Math.min(res, rightPos[i] - i);
            }
            ans = Math.max(ans, res);
        }
        return ans;
    }
}