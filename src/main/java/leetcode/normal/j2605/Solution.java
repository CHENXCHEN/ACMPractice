package leetcode.normal.j2605;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/form-smallest-number-from-two-digit-arrays/">2605. 从两个数字数组里生成最小数字</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int[] vis = new int[10];
        for (int num : nums1) {
            vis[num]++;
        }
        for (int num : nums2) {
            vis[num]++;
        }
        for (int i = 0; i <= 9; i++) {
            if (vis[i] > 1) return i;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if (nums1[0] > nums2[0]) return nums2[0] * 10 + nums1[0];
        else return nums1[0] * 10 + nums2[0];
    }
}