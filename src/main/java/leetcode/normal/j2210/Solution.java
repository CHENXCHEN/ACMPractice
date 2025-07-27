package leetcode.normal.j2210;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-hills-and-valleys-in-an-array/description/">2210. 统计数组中峰和谷的数量</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countHillValley(int[] nums) {
        int i = 1, n = nums.length, ans = 0;
        while (i + 1 < n) {
            int j = i + 1;
            while (j < n && nums[j] == nums[i]) j++;
            if (j < n) {
                if ((nums[i - 1] < nums[i] && nums[i] > nums[j]) || (nums[i - 1] > nums[i] && nums[i] < nums[j])) {
                    ans ++;
                }
            }
            i = j;
        }
        return ans;
    }
}