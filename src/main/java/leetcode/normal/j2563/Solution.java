package leetcode.normal.j2563;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-the-number-of-fair-pairs/description/">2563. 统计公平数对的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        // 排序不影响结果
        Arrays.sort(nums);
        int left = 0, right = 0;
        long ans = 0;
//        System.out.println(Arrays.toString(nums));
        for (int i = nums.length - 1; i > 0; i--) {
            // 枚举左边界，随着 nums[i] 的减少，左边界要增加
            while (left < i && lower > nums[left] + nums[i]) {
                left++;
            }
            right = Math.min(right, i);
            // 枚举有边界，随着 nums[i] 的减少，右边界要增加
            while (right < i && nums[right] + nums[i] <= upper) {
                right++;
            }
//            System.out.printf("i: %d left: %d, right: %d\n", i, left, right);
            if ((left < i && lower <= nums[left] + nums[i]) && (right > 0 && right <= i && nums[right - 1] + nums[i] <= upper)) {
                ans += right - left;
            }
        }
        return ans;
    }
}