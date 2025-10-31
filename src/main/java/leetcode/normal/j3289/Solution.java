package leetcode.normal.j3289;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/the-two-sneaky-numbers-of-digitville/description/">3289. 数字小镇中的捣蛋鬼</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int[] visited = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ++visited[nums[i]];
            if (visited[nums[i]] > 1) {
                ans.add(nums[i]);
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}