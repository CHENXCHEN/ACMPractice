package leetcode.normal.j2367;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-arithmetic-triplets/">2367. 算术三元组的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j < nums.length && nums[j] - nums[i] < diff) ++j;
            if (j < nums.length && nums[j] - nums[i] == diff) {
                int k = j + 1;
                while (k < nums.length && nums[k] - nums[j] < diff) ++k;
                if (k < nums.length && nums[k] - nums[j] == diff) {
                    ++ans;
                }
            }
        }
        return ans;
    }
}