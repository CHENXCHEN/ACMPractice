package leetcode.normal.j3201;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-maximum-length-of-valid-subsequence-i/description/">3201. 找出有效子序列的最大长度 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximumLength(int[] nums) {
        // 奇数，偶数，交叉数
        int oddCnt = 0, evenCnt = 0, cycleCnt = 0, lastCycle = -1;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i] % 2;
            if (cur == 0) {
                ++evenCnt;
            } else {
                ++oddCnt;
            }
            if (i == 0) {
                cycleCnt = 1;
                lastCycle = cur;
            } else if (lastCycle != cur) {
                cycleCnt++;
                lastCycle = cur;
            }
        }
        return Math.max(evenCnt, Math.max(oddCnt, cycleCnt));
    }
}