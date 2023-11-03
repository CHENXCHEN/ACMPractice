package leetcode.normal.j421;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/description/">421. 数组中两个数的最大异或值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    TreeNode root;

    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        root = new TreeNode();
        for (int i = 1; i < nums.length; i++) {
            add(nums[i - 1]);
            ans = Math.max(ans, query(nums[i]));
        }
        return ans;
    }

    class TreeNode {
        TreeNode[] child = new TreeNode[2];
    }

    void add(int num) {
        TreeNode head = root;
        for (int i = 30; i >= 0; i--) {
            int pos = (num >> i) & 1;
            if (head.child[pos] == null) {
                head.child[pos] = new TreeNode();
            }
            head = head.child[pos];
        }
    }

    int query(int num) {
        TreeNode head = root;
        int ans = 0;
        for (int i = 30; i >= 0; i--) {
            int pos = (num >> i) & 1;
            if (head.child[pos ^ 1] != null) {
                ans = (ans << 1) | 1;
                head = head.child[pos ^ 1];
            } else {
                ans = (ans << 1);
                head = head.child[pos];
            }
        }
        return ans;
    }
}