package leetcode.normal.j2708;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-strength-of-a-group/description/">2708. 一个小组的最大实力值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long maxStrength(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int zeroCnt = 0, negCnt = 0, posCnt = 0;
        int maxNeg = -9;
        long prod = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                negCnt++;
                prod *= nums[i];
                maxNeg = Math.max(maxNeg, nums[i]);
            } else if (nums[i] == 0) {
                zeroCnt++;
            } else {
                prod *= nums[i];
                posCnt++;
            }
        }
        if (negCnt <= 1 && zeroCnt > 0 && posCnt == 0) return 0;
        if (prod < 0) return prod / maxNeg;
        else return prod;
    }
}