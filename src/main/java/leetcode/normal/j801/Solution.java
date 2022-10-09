package leetcode.normal.j801;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-swaps-to-make-sequences-increasing/">801. 使序列递增的最小交换次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">&#x62A5;&#x65F6;</a>
 */
class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int dp0 = 0, dp1 = 1;
        for (int i = 1; i < n; i++) {
            int pre0 = dp0, pre1 = dp1;
            boolean status1 = nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1];
            boolean status2 = nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1];
            dp0 = dp1 = n;
            if (status1) {
                dp0 = pre0;
                dp1 = pre1 + 1;
            }
            if (status2) {
                dp0 = Math.min(dp0, pre1);
                dp1 = Math.min(dp1, pre0 + 1);
            }
        }
        return Math.min(dp0, dp1);
    }
}