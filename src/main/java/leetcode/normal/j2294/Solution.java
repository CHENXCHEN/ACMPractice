package leetcode.normal.j2294;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/partition-array-such-that-maximum-difference-is-k/description/">2294. 划分数组使最大差为 K</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1, last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - last > k) {
                last = nums[i];
                ++ans;
            }
        }
        return ans;
    }
}