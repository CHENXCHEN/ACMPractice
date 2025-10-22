package leetcode.normal.j3347;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-frequency-of-an-element-after-performing-operations-ii/description/">3347. 执行操作后元素的最高频率 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int ans = 0;
        Map<Integer, Integer> numCnt = new HashMap<>();
        int lastNumIdx = 0, n = nums.length;
        // 将左右可能的起点都加入候选值中
        Consumer<Integer> addNum = (key) -> {
            if (key - k >= nums[0]) numCnt.computeIfAbsent(key - k, x -> 0);
            if (key + k <= nums[n - 1]) numCnt.computeIfAbsent(key + k, x -> 0);
        };
        for (int i = 0; i < n; i++) {
            if (nums[i] != nums[lastNumIdx]) {
                numCnt.put(nums[lastNumIdx], i - lastNumIdx);
                ans = Math.max(ans, i - lastNumIdx);
                addNum.accept(nums[lastNumIdx]);
                lastNumIdx = i;
            }
        }
        numCnt.put(nums[lastNumIdx], n - lastNumIdx);
        ans = Math.max(ans, n - lastNumIdx);
        addNum.accept(nums[lastNumIdx]);
        // 枚举最小到最大的值，假设这个值为众数，需要操作多少次
        for (Integer num : numCnt.keySet()) {
            int l = leftBinarySearch(nums, num - k);
            int r = rightBinarySearch(nums, num + k);
            // 当前数字的众数，不超过区间长度，和可操作次数
            int cur = Math.min(r - l + 1, numOperations + numCnt.getOrDefault(num, 0));
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