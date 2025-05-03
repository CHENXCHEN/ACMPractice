package leetcode.normal.j1007;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-domino-rotations-for-equal-row/description/">1007. 行相等的最少多米诺旋转</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
           int cnt = minOpCnt(i, tops, bottoms);
           if (cnt != -1) ans = Math.min(ans, cnt);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    int minOpCnt(int fin, int[] tops, int[] bottoms) {
        int n = tops.length;
        int topCnt = 0, bottomCnt = 0;
        for (int i = 0; i < n; i++) {
            if (tops[i] != fin && bottoms[i] != fin) return -1;
            if (tops[i] != fin && bottoms[i] == fin) topCnt++;
            if (tops[i] == fin && bottoms[i] != fin) bottomCnt++;
        }
        return Math.min(topCnt, bottomCnt);
    }
}