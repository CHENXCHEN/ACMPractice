package leetcode.normal.j2176;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-equal-and-divisible-pairs-in-an-array/description/">2176. 统计数组中相等且可以被整除的数对</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countPairs(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j] && (i * j % k == 0)) ++ans;
            }
        }
        return ans;
    }
}