package leetcode.normal.j2569;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/handling-sum-queries-after-update/">2569. 更新数组后处理求和查询</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    static class TreeNode {
        int l = 0, r = 0, sum = 0;
        private int mid = -1, len = -1;
        boolean reverse = false;

        void doReverse() {
            sum = getLen() - sum;
            reverse = !reverse;
        }

        int getMid() {
            if (mid == -1) mid = (l + r) >> 1;
            return mid;
        }

        int getLen() {
            if (len == -1) len = r - l + 1;
            return len;
        }
    }

    TreeNode[] treeNodes;


    void pushDown(int id) {
        int leftId = id << 1, rightId = id << 1 | 1;
        if (treeNodes[id].reverse) {
            treeNodes[id].reverse = false;
            treeNodes[leftId].doReverse();
            treeNodes[rightId].doReverse();
        }
    }

    void pushUp(int id) {
        int leftId = id << 1, rightId = id << 1 | 1;
        treeNodes[id].sum = treeNodes[leftId].sum + treeNodes[rightId].sum;
    }

    void build(int id, int l, int r, int[] nums) {
        treeNodes[id] = new TreeNode();
        treeNodes[id].l = l;
        treeNodes[id].r = r;
        if (l == r) {
            treeNodes[id].sum = nums[l];
            return;
        }
        int mid = treeNodes[id].getMid();
        int leftId = id << 1, rightId = id << 1 | 1;
        build(leftId, l, mid, nums);
        build(rightId, mid + 1, r, nums);
        pushUp(id);
    }

    void modified(int id, int opLeft, int opRight) {
        if (opLeft <= treeNodes[id].l && treeNodes[id].r <= opRight) {
            treeNodes[id].doReverse();
            return;
        }
        pushDown(id);
        int leftId = id << 1, rightId = id << 1 | 1;
        int mid = treeNodes[id].getMid();
        if (mid >= opLeft) modified(leftId, opLeft, opRight);
        if (mid < opRight) modified(rightId, opLeft, opRight);
        pushUp(id);
    }

    long query(int id, int opLeft, int opRight) {
        if (opLeft <= treeNodes[id].l && treeNodes[id].r <= opRight) {
            return treeNodes[id].sum;
        }
        if (treeNodes[id].l > opRight || treeNodes[id].r < opLeft) return 0L;
        pushDown(id);
        long ans = 0L;
        int leftId = id << 1, rightId = id << 1 | 1;
        int mid = treeNodes[id].getMid();
        if (mid >= opLeft) ans += query(leftId, opLeft, opRight);
        if (mid < opRight) ans += query(rightId, opLeft, opRight);
        return ans;
    }

    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        treeNodes = new TreeNode[nums1.length << 2 | 1];
        long sum = 0;
        int n = nums1.length;
        build(1, 0, n - 1, nums1);
        for (int num : nums2) sum += num;
        ArrayList<Long> lst = new ArrayList<>();
        for (int[] opQuery : queries) {
            if (opQuery[0] == 1) {
                modified(1, opQuery[1], opQuery[2]);
            } else if (opQuery[0] == 2) {
                sum += opQuery[1] * query(1, 0, n - 1);
            } else if (opQuery[0] == 3) {
                lst.add(sum);
            }
        }
        long[] ans = new long[lst.size()];
        for (int i = 0; i < ans.length; i++) ans[i] = lst.get(i);
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 0, 1}, nums2 = {0, 0, 0};
        int[][] queries = {{1, 1, 1}, {2, 1, 0}, {3, 0, 0}};
        solution.handleQuery(nums1, nums2, queries);
    }
}