package leetcode.normal.j532;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/k-diff-pairs-in-an-array/
 * 532. 数组中的 k-diff 数对
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                // num[i] - num[j] = k => num[j] = num[i] - k
                if (binarySearch(nums, i - 1, nums[i] - k)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    boolean binarySearch(int[] nums, int end, int target) {
        int left = 0, right = end;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) return true;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}