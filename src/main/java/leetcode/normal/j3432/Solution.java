package leetcode.normal.j3432;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-partitions-with-even-sum-difference/description/">3432. 统计元素和差值为偶数的分区方案</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countPartitions(int[] nums) {
        int ss = Arrays.stream(nums).sum();
        int ans = 0, leftSum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            int diff = leftSum - (ss - leftSum);
            if (diff % 2 == 0) ++ans;
        }
        return ans;
    }
}