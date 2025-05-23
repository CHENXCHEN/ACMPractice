package leetcode.normal.j3068;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-maximum-sum-of-node-values/description/">3068. 最大节点价值之和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long ans = 0;
        // 对于树上的任意两点，存在一种方式，使得首位都异或奇数次 k，而中间路径上的点都异或偶数次 k
        int[] diff = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans += nums[i];
            diff[i] = (nums[i] ^ k) - nums[i];
        }
        Arrays.sort(diff);
        for (int i = diff.length - 1; i > 0 && diff[i] + diff[i - 1] >= 0; i -= 2) {
            ans += diff[i] + diff[i - 1];
        }
        return ans;
    }
}