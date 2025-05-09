package leetcode.normal.j2918;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/description/">2918. 数组的最小相等和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0, cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < nums1.length; i++) {
            sum1 += nums1[i];
            if (nums1[i] == 0) ++cnt1;
        }
        for (int i = 0; i < nums2.length; i++) {
            sum2 += nums2[i];
            if (nums2[i] == 0) ++cnt2;
        }
        if (cnt1 == 0 && cnt2 == 0) {
            if (sum1 != sum2) return -1;
            else return sum1;
        } else if (cnt1 == 0) {
            if (sum1 >= sum2 + cnt2) return sum1;
            else return -1;
        } else if (cnt2 == 0) {
            if (sum1 + cnt1 <= sum2) return sum2;
            else return -1;
        } else {
            return Math.max(sum1 + cnt1, sum2 + cnt2);
        }
    }
}