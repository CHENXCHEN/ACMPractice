package leetcode.normal.j1803;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-pairs-with-xor-in-a-range/description/">1803. 统计异或值在范围内的数对有多少</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    class TreeNode {
        TreeNode[] child = new TreeNode[2];
        int cnt = 0;
    }

    TreeNode root;
    int[] nums;

    void insert(int num) {
        TreeNode tree = root;
        for (int i = 14; i >= 0; i--) {
            int cur = (num >> i) & 1;
            if (tree.child[cur] == null) tree.child[cur] = new TreeNode();
            tree = tree.child[cur];
            tree.cnt++;
        }
    }

    public int countPairs(int[] nums, int low, int high) {
        this.nums = nums;
        return calc(high) - calc(low - 1);
    }

    int calc(int x) {
        int ans = 0;
        root = new TreeNode();
        for (int i = 1; i < nums.length; i++) {
            insert(nums[i - 1]);
            ans += get(nums[i], x);
        }
        return ans;
    }

    int get(int num, int x) {
        TreeNode tree = root;
        int cnt = 0;
        for (int i = 14; i >= 0; i--) {
            int r = (num >> i) & 1;
            if (((x >> i) & 1) == 1) {
                // 如果 x 的第 i 位为 1，那么在数组中第 i 位异或为 0 的一定是小于 x 的，
                // 那么需要找出和 num 的第 i 位相同的数字
                if (tree.child[r] != null) cnt += tree.child[r].cnt;
                tree = tree.child[r ^ 1];
            } else {
                tree = tree.child[r];
            }
            if (tree == null) return cnt;
        }
        cnt += tree.cnt;
        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.countPairs(new int[]{1, 4, 2, 7}, 2, 6);
    }
}