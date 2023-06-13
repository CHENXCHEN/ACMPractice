package leetcode.normal.j2475;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-unequal-triplets-in-array/">2475. 数组中不等三元组的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int unequalTriplets(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] != nums[j]) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] != nums[k] && nums[j] != nums[k]) {
                            ++ans;
                        }
                    }
                }
            }
        }
        return ans;
    }
}