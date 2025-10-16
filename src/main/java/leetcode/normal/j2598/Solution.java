package leetcode.normal.j2598;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/smallest-missing-non-negative-integer-after-operations/description/">2598. 执行操作后的最大 MEX</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] mark = new int[value];
        for (int i = 0; i < nums.length; i++) {
            int num = (nums[i] % value + value) % value;
            mark[num]++;
        }
        int min = Integer.MAX_VALUE, minIdx = 0;
        for (int i = 0; i < mark.length; i++) {
            if (mark[i] == 0) return i;
            if (min > mark[i]) {
                min = mark[i];
                minIdx = i;
            }
        }
        return minIdx + min * value;
    }
}