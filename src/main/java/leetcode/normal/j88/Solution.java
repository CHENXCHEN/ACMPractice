package leetcode.normal.j88;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/merge-sorted-array/">88. 合并两个有序数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m + n];
        int i = 0, j = 0, tot = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) ans[tot++] = nums1[i++];
            else ans[tot++] = nums2[j++];
        }
        while (i < m) ans[tot++] = nums1[i++];
        while (j < n) ans[tot++] = nums2[j++];
        for (int k = 0; k < tot; k++) nums1[k] = ans[k];
    }
}