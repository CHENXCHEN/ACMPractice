package leetcode.normal.j915;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/partition-array-into-disjoint-intervals/">915. 分割数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int partitionDisjoint(int[] nums) {
        int ans = 1, n = nums.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) pre[i] = Math.max(pre[i - 1], nums[i]);
        int rightMin = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 1; i--) {
            rightMin = Math.min(rightMin, nums[i]);
            if (pre[i - 1] <= rightMin) {
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5,0,3,8,6};
        Solution solution = new Solution();
        solution.partitionDisjoint(nums);
    }
}