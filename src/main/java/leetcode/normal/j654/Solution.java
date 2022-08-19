package leetcode.normal.j654;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-binary-tree/">654. 最大二叉树</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    TreeNode build(int[] nums, int left, int right) {
        if (left > right) return null;
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int maxVal = nums[left], maxPos = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxPos = i;
            }
        }
        return new TreeNode(maxVal, build(nums, left, maxPos - 1), build(nums, maxPos + 1, right));
    }
}