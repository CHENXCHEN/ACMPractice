package leetcode.normal.j870;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/advantage-shuffle/">870. 优势洗牌</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Integer[] pos = new Integer[nums2.length];
        for (int i = 0; i < nums2.length; i++) pos[i] = i;
        Arrays.sort(pos, Comparator.comparingInt(i -> nums2[i]));
        Arrays.sort(nums1);
        int[] ans = new int[nums2.length];
        int first1 = 0, first2 = 0, last = nums2.length;
        while (first1 < nums2.length) {
            if (nums1[first1] > nums2[pos[first2]]) {
                ans[pos[first2++]] = nums1[first1++];
            } else {
                ans[pos[--last]] = nums1[first1++];
            }
        }
        return ans;
    }
}