package leetcode.normal.j1031;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-sum-of-two-non-overlapping-subarrays/">1031. 两个非重叠子数组的最大和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(check(nums, firstLen, secondLen), check(nums, secondLen, firstLen));
    }

    int check(int[] nums, int firstLen, int secondLen) {
        int sumL = 0, sumR = 0, maxL, n = nums.length;
        for (int i = 0; i < firstLen; i++) sumL += nums[i];
        for (int i = firstLen; i < firstLen + secondLen; i++) sumR += nums[i];
        maxL = sumL;
        int ans = sumL + sumR;
        for (int lPos = firstLen, rPos = firstLen + secondLen; rPos < n; lPos++, rPos++) {
            sumL += nums[lPos] - nums[lPos - firstLen];
            maxL = Math.max(maxL, sumL);
            sumR += nums[rPos] - nums[rPos - secondLen];
            ans = Math.max(ans, maxL + sumR);
        }
        return ans;
    }
}