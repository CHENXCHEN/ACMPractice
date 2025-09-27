package leetcode.normal.j611;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/valid-triangle-number/description/">611. 有效三角形的个数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int triangleNumber(int[] nums) {
        // 三角形不等式，任意两最小边之和大于第三条边即可
        Arrays.sort(nums);
        int ans = 0;
//        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int idx = binarySearch(nums, j + 1, nums.length - 1, nums[i] + nums[j]);
//                System.out.println("i = " + i + ", j = " + j + ", idx = " + idx);
                // 最短的两边，第三边要大于等于第二边
                if (idx != -1 && nums[idx] >= nums[j]) {
                    ans += idx - j;
                }
            }
        }
        return ans;
    }

    int binarySearch(int[] nums, int left, int right, int target) {
        // 找到小于 target 的最大下标
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}