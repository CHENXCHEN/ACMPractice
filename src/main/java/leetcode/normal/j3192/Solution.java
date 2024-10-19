package leetcode.normal.j3192;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-ii/description/">3192. 使二进制数组全部等于 1 的最少操作次数 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minOperations(int[] nums) {
        int revCnt = 0;
        for (int num : nums) {
            if (num == 0) {
                if ((revCnt & 1) == 0) {
                    ++revCnt;
                }
            } else {
                if ((revCnt & 1) == 1) {
                    ++revCnt;
                }
            }
        }
        return revCnt;
    }
}