package leetcode.normal.j307;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/range-sum-query-mutable/description/">307. 区域和检索 - 数组可修改</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class NumArray {
    static class TreeNode {
        int left, right, val;

        TreeNode(int _left, int _right) {
            left = _left;
            right = _right;
        }
    }

    TreeNode[] treeNodes;
    int n;
    int[] nums;

    public NumArray(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        treeNodes = new TreeNode[n << 2];
        build(1, 0, n - 1);
    }

    void build(int pos, int left, int right) {
        treeNodes[pos] = new TreeNode(left, right);
        if (left == right) {
            treeNodes[pos].val = nums[left];
            return;
        }
        int mid = (left + right) >> 1;
        if (left <= mid) build(pos << 1, left, mid);
        if (right > mid) build(pos << 1 | 1, mid + 1, right);
        treeNodes[pos].val = treeNodes[pos << 1].val + treeNodes[pos << 1 | 1].val;
    }

    void updateTree(int pos, int idx, int val) {
        if (treeNodes[pos].left == treeNodes[pos].right) {
            treeNodes[pos].val = val;
            return;
        }
        int mid = (treeNodes[pos].left + treeNodes[pos].right) >> 1;
        if (idx <= mid) updateTree(pos << 1, idx, val);
        else updateTree(pos << 1 | 1, idx, val);
        treeNodes[pos].val = treeNodes[pos << 1].val + treeNodes[pos << 1 | 1].val;
    }

    int queryTree(int pos, int left, int right) {
        if (left <= treeNodes[pos].left && treeNodes[pos].right <= right) {
            return treeNodes[pos].val;
        }
        int mid = (treeNodes[pos].left + treeNodes[pos].right) >> 1;
        int ans = 0;
        if (left <= mid) ans += queryTree(pos << 1, left, right);
        if (right > mid) ans += queryTree(pos << 1 | 1, left, right);
        return ans;
    }

    public void update(int index, int val) {
        updateTree(1, index, val);
    }

    public int sumRange(int left, int right) {
        return queryTree(1, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */