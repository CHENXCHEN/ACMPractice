package leetcode.normal.j2644;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-maximum-divisibility-score/description/">2644. 找出可整除性得分最大的整数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int cnt = 0, last = divisors[0];
        for (int divisor : divisors) {
            int _cnt = 0;
            for (int num : nums) {
                if (num % divisor == 0) ++_cnt;
            }
            if (_cnt > cnt) {
                cnt = _cnt;
                last = divisor;
            } else if (_cnt == cnt && last > divisor) {
                last = divisor;
            }
        }
        return last;
    }
}