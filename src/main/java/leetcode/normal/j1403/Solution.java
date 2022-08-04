package leetcode.normal.j1403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-subsequence-in-non-increasing-order/">1403. 非递增顺序的最小子序列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, tot = Arrays.stream(nums).sum();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            ans += nums[i];
            tot -= nums[i];
            arr.add(nums[i]);
            if (ans > tot) {
                break;
            }
        }
        return arr;
    }
}