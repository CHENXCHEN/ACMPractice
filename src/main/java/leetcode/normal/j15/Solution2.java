package leetcode.normal.j15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/3sum/">15. 三数之和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            // 剪枝，只需要考虑第一个元素是负数的情况就可以了，因为至少有一个负数这个等式才成立
            if (nums[i] > 0) break;
            // 剪枝，如果是相同元素，那么可以跳过
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = n - 1;
            while (left < right) {
                int cmp = nums[i] + nums[left] + nums[right];
                // 如果加起来大于目标值，那么代表 [left, right-1] 这些位置和 right 加起来都会大于目标
                // 如果加起来小于目标值，那么代表 [left+1, right] 这些位置和 left 加起来都会小于目标
                // 如果加起来等于目标值，那么代表值等于 left 和 right 的解都相等，记录并跳过
                if (cmp > 0) right--;
                else if (cmp < 0) left++;
                else {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left + 1] == nums[left]) left++;
                    while (left < right && nums[right - 1] == nums[right]) right--;
                    left++;
                    right--;
                }
            }
        }
        return ans;
    }
}