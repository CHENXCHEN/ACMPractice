package leetcode.normal.j719;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/find-k-th-smallest-pair-distance/
 * 719. 找出第 K 小的数对距离
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution3 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];
        while (left <= right) {
            int mid = (left + right) >> 1;
            int cnt = 0;
            // 计算 <= mid 的对数有多少
            // mid >= num[i] - num[j]，枚举 i，求有多少 j
            // num[j] >= num[i] - mid 找到最小的 j，则有 i - j 个解
            // 可以通过双指针查找
            for (int i = 0, j = 0; j < nums.length; j++) {
                while (nums[j] - nums[i] > mid) i++;
                cnt += j - i;
            }
            if (cnt >= k) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    int binarySearch(int[] nums, int end, int target) {
        int left = 0, right = end;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int[] nums = {62, 100, 4};
        System.out.println(solution.smallestDistancePair(nums, 2));
    }
}
