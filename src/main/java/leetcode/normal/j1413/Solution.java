package leetcode.normal.j1413;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/">1413. 逐步求和得到正数的最小值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minStartValue(int[] nums) {
        int start = 1, cur = 1;
        for (int num : nums) {
            cur += num;
            if (cur <= 0) {
                start += -cur + 1;
                cur = 1;
            }
        }
        return start;
    }
}