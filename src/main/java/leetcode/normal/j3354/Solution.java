package leetcode.normal.j3354;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/make-array-elements-equal-to-zero/description/">3354. 使数组元素等于零</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        if (n == 1) return 2;
        int[] leftSum = new int[n], rightSum = new int[n];
        leftSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i];
        }
        rightSum[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) continue;
            // 如果左前缀和 = 右前缀和，那么往左右任意一个方向开始都可以
            // 如果abs(左前缀和 - 右前缀和) = 1，那么必须要往多的那个方向开始
            int ll = i - 1 >= 0 ? leftSum[i - 1] : 0;
            int rr = i + 1 < n ? rightSum[i + 1] : 0;
            int abs = Math.abs(ll - rr);
            if (abs <= 1) {
                ans += 2 - abs;
            }
        }
        return ans;
    }
}