package leetcode.normal.j3185;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-pairs-that-form-a-complete-day-ii/description/">3185. 构成整天的下标对数目 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long countCompleteDayPairs(int[] hours) {
        int[] cnt = new int[24];
        long ans = 0;
        for (int hour : hours) {
            hour %= 24;
            ans += cnt[(24 - hour) % 24];
            cnt[hour]++;
        }
        return ans;
    }
}