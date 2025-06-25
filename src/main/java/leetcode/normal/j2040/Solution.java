package leetcode.normal.j2040;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/kth-smallest-product-of-two-sorted-arrays/description/">2040. 两个有序数组的第 K 小乘积</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int n1 = nums1.length;
        long left = -10000000000L, right = 10000000000L;
        while (left <= right) {
            // 二分乘积，求这个乘积是第几个小的
            long mid = (left + right) >> 1;
            long count = 0;
            for (int i = 0; i < n1; i++) {
                // 计算选 nums1[i]，可以组成的不超过 mid 的数量有多少
                count += calc(nums2, nums1[i], mid);
            }
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    int calc(int[] nums2, long x1, long v) {
        int n2 = nums2.length;
        int left = 0, right = n2 - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            long prod = (long) nums2[mid] * x1;
            // 如果 x1 >= 0，随着 mid 增加，x1 * nums2[mid] 是递增的
            // 如果 x1 <  0，随着 mid 增加，x1 * nums2[mid] 是递减的
            if ((x1 >= 0 && prod <= v) || (x1 < 0 && prod > v)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (x1 >= 0) return left;
        else return n2 - left;
    }
}