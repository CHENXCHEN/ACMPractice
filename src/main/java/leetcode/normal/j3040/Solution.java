package leetcode.normal.j3040;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-number-of-operations-with-the-same-score-ii/description/">3040. 相同分数的最大操作数目 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] mem;
    int[] nums;
    int n;

    public int maxOperations(int[] nums) {
        this.nums = nums;
        n = nums.length;
        mem = new int[n][n];
        return Math.max(solve(nums[0] + nums[n - 1]),
                Math.max(solve(nums[0] + nums[1]), solve(nums[n - 2] + nums[n - 1])));
    }

    int solve(int target) {
        init();
        return dfs(0, n - 1, target);
    }

    int dfs(int i, int j, int target) {
        if (i >= j) return 0;
        if (mem[i][j] != -1) return mem[i][j];
        int cur = 0;
        if (nums[i] + nums[i + 1] == target) {
            cur = 1 + dfs(i + 2, j, target);
        }
        if (nums[i] + nums[j] == target) {
            cur = Math.max(cur, 1 + dfs(i + 1, j - 1, target));
        }
        if (nums[j - 1] + nums[j] == target) {
            cur = Math.max(cur, 1 + dfs(i, j - 2, target));
        }
        mem[i][j] = cur;
        return cur;
    }

    void init() {
        for (int i = 0; i < n; i++) Arrays.fill(mem[i], -1);
    }
}