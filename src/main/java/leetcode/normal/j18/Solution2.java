package leetcode.normal.j18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/4sum/">18. 四数之和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    int[] nums;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        this.nums = nums;
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n - 3; i++) {
            // 剪枝：如果以 nums[i] 开头的前面已经枚举过，那当前一定会重复
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 剪枝：如果最小的四个数之和都大于 target，那后面一定不可能
            if (sum(i, i + 1, i + 2, i + 3) > target) break;
            // 剪枝：如果最大的情况都小于 target，那么 nums[i] 开头的 一定不可能
            if (sum(i, n - 1, n - 2, n - 3) < target) continue;
            for (int j = i + 1; j < n - 2; j++) {
                // 剪枝：如果当前元素已经用过，那么当前一定会重复
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                // 剪枝：如果最小的都大于 target，那么后面一定不可能
                if (sum(i, j, j + 1, j + 2) > target) break;
                // 剪枝：如果最大的都小于 target，那么当前一定不可能
                //      为什么这里不 break ?
                //          当 nums[j] 为负数，当后面变为正数时，会使得和 大于 target
                //          当 nums[j] 为正数，当后面的数更大时，会使得和 大于 target
                if (sum(i, j, n - 1, n - 2) < target) continue;
                int left = j + 1, right = n - 1;
                long preSum = nums[i] + nums[j];
                while (left < right) {
                    long curSum = preSum + nums[left] + nums[right];
                    if (curSum < target) {
                        left++;
                    } else if (curSum > target) {
                        right--;
                    } else {
                        ArrayList<Integer> cur = new ArrayList<>();
                        cur.add(nums[i]);
                        cur.add(nums[j]);
                        cur.add(nums[left]);
                        cur.add(nums[right]);
                        ans.add(cur);
                        while (left < right && nums[left + 1] == nums[left]) left++;
                        while (left < right && nums[right - 1] == nums[right]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return ans;
    }

    long sum(int i, int j, int m, int n) {
        return (long) nums[i] + nums[j] + nums[m] + nums[n];
    }
}