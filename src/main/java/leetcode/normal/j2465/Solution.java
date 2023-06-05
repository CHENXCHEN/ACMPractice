package leetcode.normal.j2465;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-distinct-averages/">2465. 不同的平均值数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> tSet = new HashSet<>();
        int left = 0, right = nums.length - 1;
        while (left < right) {
            tSet.add(nums[left] + nums[right]);
            left++;
            right--;
        }
        return tSet.size();
    }
}