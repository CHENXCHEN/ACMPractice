package leetcode.normal.j698;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/">698. 划分为k个相等的子集</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    boolean[] has;
    int[] nums;
    int n, k, sub;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.n = nums.length;
        this.k = k;
        this.nums = nums;
        has = new boolean[1 << n];
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        this.sub = sum / k;
        return dfs(0, 1, 0);
    }

    boolean dfs(int status, int part, int sum) {
        if (sum > sub) return false;
        if (sum == sub) {
            ++part;
            sum = 0;
        }
        if (part == k) return true;
        if (has[status]) return false;
        for (int i = 0; i < n; i++) {
            if ((((status) >> i) & 1) == 0) {
                int select = status | (1 << i);
                if (dfs(select, part, sum + nums[i])) return true;
                else has[select] = true;
            }
        }
        return false;
    }
}