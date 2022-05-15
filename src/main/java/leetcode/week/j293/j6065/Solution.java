package leetcode.week.j293.j6065;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/largest-combination-with-bitwise-and-greater-than-zero/
 * 6065. 按位与结果大于零的最长组合
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int largestCombination(int[] candidates) {
        int ans = 1;
        for (int i = 0; i < 32; i++) {
            int bitPos = 1 << i;
            int cntOne = 0;
            for (int candidate : candidates) {
                if ((candidate & bitPos) != 0) {
                    cntOne++;
                }
            }
            ans = Math.max(cntOne, ans);
        }
        return ans;
    }
}