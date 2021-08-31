package leetcode.normal.j1109;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/corporate-flight-bookings/
 * 1109. 航班预订统计
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    static class TreeNode {
        public int l, r, acc;

        TreeNode(int l, int r, int acc) {
            this.l = l;
            this.r = r;
            this.acc = acc;
        }

        public int mid() {
            return (l + r) >> 1;
        }
    }

    void build(TreeNode[] tree, int n, int l, int r) {
        tree[n] = new TreeNode(l, r, 0);
        if (l >= r) return;
        int mid = tree[n].mid();
        build(tree, n << 1, l, mid);
        build(tree, n << 1 | 1, mid + 1, r);
    }

    void pushDown(TreeNode[] tree, int n) {
        if (tree[n].acc > 0 && tree[n].l != tree[n].r) {
            TreeNode leftNode = tree[n << 1];
            if (leftNode != null) leftNode.acc += tree[n].acc;
            TreeNode rightNode = tree[n << 1 | 1];
            if (rightNode != null) rightNode.acc += tree[n].acc;
            tree[n].acc = 0;
        }
    }

    void insert(TreeNode[] tree, int n, int l, int r, int vv) {
        pushDown(tree, n);
        if (l <= tree[n].l && tree[n].r <= r) {
            tree[n].acc += vv;
        } else {
            int mid = tree[n].mid();
            if (l <= mid) insert(tree, n << 1, l, r, vv);
            if (r > mid) insert(tree, n << 1 | 1, l, r, vv);
        }
    }

    int query(TreeNode[] tree, int n, int pos) {
        pushDown(tree, n);
        if (tree[n].l == tree[n].r) {
            return tree[n].acc;
        } else {
            if (pos <= tree[n].mid()) return query(tree, n << 1, pos);
            else return query(tree, n << 1 | 1, pos);
        }
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        TreeNode[] tree = new TreeNode[n << 2];
        int[] ans = new int[n];
        build(tree, 1, 1, n);
        for (int[] booking : bookings) {
            insert(tree, 1, booking[0], booking[1], booking[2]);
        }

        for (int i = 0; i < n; i++) ans[i] = query(tree, 1, i + 1);
        return ans;
    }
}