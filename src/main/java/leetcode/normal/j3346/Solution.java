package leetcode.normal.j3346;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-frequency-of-an-element-after-performing-operations-i/description/">3346. 执行操作后元素的最高频率 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int ans = 0;
        Map<Integer, Integer> numCnt = new HashMap<>();
        int lastNumIdx = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != nums[lastNumIdx]) {
                numCnt.put(nums[lastNumIdx], i - lastNumIdx);
                ans = Math.max(ans, i - lastNumIdx);
                lastNumIdx = i;
            }
        }

        numCnt.put(nums[lastNumIdx], n - lastNumIdx);
        ans = Math.max(ans, n - lastNumIdx);
        // 枚举最小到最大的值，假设这个值为众数，需要操作多少次
        for (int i = nums[0]; i <= nums[n - 1]; i++) {
            int l = leftBinarySearch(nums, i - k);
            int r = rightBinarySearch(nums, i + k);
            // 当前数字的众数，不超过区间长度，和可操作次数
            int cur = Math.min(r - l + 1, numOperations + numCnt.getOrDefault(i, 0));
            ans = Math.max(ans, cur);
        }
        return ans;
    }

    int leftBinarySearch(int[] nums, int target) {
        // 找到 >= target 的最小下标
        int left = 0, right = nums.length - 1, ans = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    int rightBinarySearch(int[] nums, int target) {
        // 找到 <= target 的最大下标
        int left = 0, right = nums.length - 1, ans = right;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}