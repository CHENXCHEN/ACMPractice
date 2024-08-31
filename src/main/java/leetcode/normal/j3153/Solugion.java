package leetcode.normal.j3153;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/sum-of-digit-differences-of-all-pairs/"></a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long sumDigitDifferences(int[] nums) {
        int[][] cnt = new int[10][10];
        for (int num : nums) {
            for (int i = 0; num > 0; i++, num /= 10) {
                cnt[i][num % 10]++;
            }
        }
        long ans = 0;
        for (int i = 0; i < cnt.length; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k < j; k++) {
                    ans += (long) cnt[i][j] * cnt[i][k];
                }
            }
        }
        return ans;
    }
}