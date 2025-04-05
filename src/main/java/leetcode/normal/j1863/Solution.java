package leetcode.normal.j1863;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/sum-of-all-subset-xor-totals/description/">1863. 找出所有子集的异或总和再求和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int ans = 0;
    int[] nums;

    public int subsetXORSum(int[] nums) {
        this.nums = nums;
        ans = 0;
        dfs(0, 0);
        return ans;
    }

    void dfs(int idx, int xor) {
        if (idx == nums.length) {
            ans += xor;
            return;
        }
        dfs(idx + 1, xor);
        dfs(idx + 1, xor ^ nums[idx]);
    }
}