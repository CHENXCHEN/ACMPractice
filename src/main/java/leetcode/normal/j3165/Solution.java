package leetcode.normal.j3165;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-sum-of-subsequence-with-non-adjacent-elements/description/">3165. 不包含相邻元素的子序列的最大和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    static class TreeNode {
        // (x, y) 表示当前区间是否包含左右端点的不相邻元素的子序列最大和
        // v00 -> 不包含左右端点
        // v01 -> 不包含左端点，可能包含右端点
        // v10 -> 可能包含左端点，不包含右端点
        // v11 -> 可能包含左右端点
        long v00, v01, v10, v11;

        void set(long v) {
            v00 = v01 = v10 = 0;
            v11 = Math.max(v, 0);
        }
    }

    TreeNode[] tree;
    int[] nums;

    void pushUp(int pos) {
        int l = pos << 1, r = pos << 1 | 1;
        tree[pos].v00 = Math.max(tree[l].v00 + tree[r].v10, tree[l].v01 + tree[r].v00);
        tree[pos].v01 = Math.max(tree[l].v00 + tree[r].v11, tree[l].v01 + tree[r].v01);
        tree[pos].v10 = Math.max(tree[l].v10 + tree[r].v10, tree[l].v11 + tree[r].v00);
        tree[pos].v11 = Math.max(tree[l].v10 + tree[r].v11, tree[l].v11 + tree[r].v01);
    }

    void build(int pos, int l, int r) {
        tree[pos] = new TreeNode();
        if (l == r) {
            tree[pos].set(nums[l]);
            return;
        }
        int mid = (l + r) / 2;
        build(pos << 1, l, mid);
        build(pos << 1 | 1, mid + 1, r);
        pushUp(pos);
    }

    void update(int pos, int l, int r, int updatePos, int val) {
        if (updatePos < l || r < updatePos) return;
        if (l == r) {
            tree[pos].set(val);
            return;
        }
        int mid = (l + r) / 2;
        update(pos << 1, l, mid, updatePos, val);
        update(pos << 1 | 1, mid + 1, r, updatePos, val);
        pushUp(pos);
    }

    public static final int MOD = 1000000007;

    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        int n = nums.length;
        tree = new TreeNode[n << 4];
        this.nums = nums;
        build(1, 0, n - 1);
        long ans = 0;
        for (int[] query : queries) {
            update(1, 0, n - 1, query[0], query[1]);
            ans = (ans + tree[1].v11) % MOD;
        }
        return (int) ans;
    }
}