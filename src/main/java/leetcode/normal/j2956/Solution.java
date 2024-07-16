package leetcode.normal.j2956;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-common-elements-between-two-arrays/description/">2956. 找到两个数组中的公共元素</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        return new int[]{calc(nums1, nums2), calc(nums2, nums1)};
    }

    int calc(int[] nums1, int[] nums2) {
        boolean[] vis = new boolean[101];
        for (int num : nums2) {
            vis[num] = true;
        }
        int ans = 0;
        for (int num : nums1) {
            if (vis[num]) ++ans;
        }
        return ans;
    }
}