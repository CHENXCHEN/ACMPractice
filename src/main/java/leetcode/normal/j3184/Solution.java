package leetcode.normal.j3184;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-pairs-that-form-a-complete-day-i/description/">3184. 构成整天的下标对数目 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countCompleteDayPairs(int[] hours) {
        int[] cnt = new int[24];
        int ans = 0;
        for (int hour : hours) {
            hour %= 24;
            ans += cnt[(24 - hour) % 24];
            cnt[hour]++;
        }
        return ans;
    }
}