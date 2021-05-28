package leetcode.normal.j477;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/total-hamming-distance/submissions/
 * 477. 汉明距离总和
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int totalHammingDistance(int[] nums) {
        int[][] bitCnt = new int[32][32];
        for (int i = 0; i < nums.length; i++) {
            for (int pos = 0; pos < 32; pos++) {
                bitCnt[pos][(nums[i] >> pos) & 1] += 1;
            }
        }
        int ans = 0;
        for (int pos = 0; pos < 32; pos++) {
            ans += bitCnt[pos][0] * bitCnt[pos][1];
        }
        return ans;
    }
}