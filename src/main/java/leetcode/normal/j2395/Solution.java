package leetcode.normal.j2395;

import java.util.HashSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-subarrays-with-equal-sum/">2395. 和相等的子数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean findSubarrays(int[] nums) {
        HashSet<Integer> hSet = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int num = nums[i] + nums[i + 1];
            if (!hSet.add(num)) {
                return true;
            }
        }
        return false;
    }
}