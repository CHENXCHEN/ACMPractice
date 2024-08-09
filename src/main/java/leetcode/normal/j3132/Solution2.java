package leetcode.normal.j3132;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-integer-added-to-array-ii/description/">3132. 找出与数组相加的整数 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution2 {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 2; i >= 0; i--) {
            int idx1 = i + 1, idx2 = 1;
            int diff = nums2[0] - nums1[i];
            while (idx1 < len1 && idx2 < len2) {
                if (nums2[idx2] - nums1[idx1] == diff) ++idx2;
                ++idx1;
            }
            if (idx2 == len2) {
                return diff;
            }
        }
        return 0;
    }
}
