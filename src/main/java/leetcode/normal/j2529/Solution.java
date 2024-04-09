package leetcode.normal.j2529;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-count-of-positive-integer-and-negative-integer/description/">2529. 正整数和负整数的最大计数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximumCount(int[] nums) {
        int pos = 0, neg = 0;
        for (int num : nums) {
            if (num > 0) ++pos;
            else if (num < 0) ++neg;
        }
        return Math.max(pos, neg);
    }
}