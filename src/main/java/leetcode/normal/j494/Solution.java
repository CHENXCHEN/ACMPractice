package leetcode.normal.j494;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/target-sum/
 * 494. 目标和
 * 回溯枚举
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    int ans = 0;

    public void findTarget(int[] nums, int index, int target, int sum) {
        if (index == nums.length) {
            if (target == sum) ans += 1;
        } else {
            findTarget(nums, index + 1, sum + nums[index], target);
            findTarget(nums, index + 1, sum - nums[index], target);
        }
    }

    public int findTargetSumWays(int[] nums, int target) {
        ans = 0;
        findTarget(nums, 0, 0, target);
        return ans;
    }
}
