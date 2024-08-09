package leetcode.normal.j3132;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-integer-added-to-array-ii/description/">3132. 找出与数组相加的整数 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] nums1, nums2;
    int len1, len2;

    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.len1 = nums1.length;
        this.len2 = nums2.length;
        TreeSet<Integer> tSet = new TreeSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 && j < nums2.length; j++) {
                tSet.add(nums2[j] - nums1[i]);
            }
        }
        for (Integer v : tSet) {
            if (validDiff(v)) return v;
        }
        return Integer.MIN_VALUE;
    }

    boolean validDiff(int diff) {
        int idx1 = 0, idx2 = 0;
        int len1 = nums1.length, len2 = nums2.length;
        while (idx1 < len1 && idx2 < len2) {
            while (idx1 < len1 && nums2[idx2] - nums1[idx1] != diff) ++idx1;
            if (idx1 < len1) {
                ++idx1;
                ++idx2;
            }
        }
        return idx2 >= len2;
    }
}