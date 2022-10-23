package leetcode.normal.j915;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/partition-array-into-disjoint-intervals/">915. 分割数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length, leftPos = 0, leftMax = nums[0], curMax = nums[0];
        for (int i = 1; i < n - 1; i++) {
            curMax = Math.max(curMax, nums[i]);
            if (nums[i] < leftMax) {
                leftPos = i;
                leftMax = curMax;
            }
        }
        return leftPos + 1;
    }
}