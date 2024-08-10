package leetcode.normal.j2940;

/**
 * Created by CHENXCHEN
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] heights;

    static class TreeNode {
        int left, right, v;

        TreeNode(int _left, int _right, int _v) {
            left = _left;
            right = _right;
            v = _v;
        }
    }

    TreeNode[] treeNodes;

    void build(int pos, int left, int right) {
        treeNodes[pos] = new TreeNode(left, right, 0);
        if (left == right) {
            treeNodes[pos].v = heights[left];
            return;
        }
        int mid = (left + right) >> 1;
        if (left <= mid) build(pos << 1, left, mid);
        if (right > mid) build(pos << 1 | 1, mid + 1, right);
        treeNodes[pos].v = Math.max(treeNodes[pos << 1].v, treeNodes[pos << 1 | 1].v);
    }

    int query(int pos, int queryLeft, int queryRight) {
        int left = treeNodes[pos].left, right = treeNodes[pos].right;
        if (queryLeft <= left && right <= queryRight) {
            return treeNodes[pos].v;
        }
        int ans = 0, mid = (left + right) >> 1;
        if (queryLeft <= mid)
            ans = query(pos << 1, queryLeft, queryRight);
        if (queryRight > mid)
            ans = Math.max(ans, query(pos << 1 | 1, queryLeft, queryRight));
        return ans;
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        this.heights = heights;
        int n = heights.length;
        int[] ans = new int[queries.length];
        treeNodes = new TreeNode[n << 2];
        build(1, 0, n - 1);
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int u = query[0], v = query[1];
            if (u > v) {
                u = query[1];
                v = query[0];
            }
            if (heights[u] < heights[v] || u == v) ans[i] = v;
            else ans[i] = findCeil(v + 1, n - 1, Math.max(heights[u], heights[v]) + 1);
        }
        return ans;
    }

    int findCeil(int left, int right, int target) {
//        System.out.printf("left: %d right: %d target: %d\n", left, right, target);
        int start = left;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int query = query(1, start, mid);
//            System.out.printf("query: [%d, %d]: %d\n", start, mid, query);
            if (query >= target) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return ans;
    }
}