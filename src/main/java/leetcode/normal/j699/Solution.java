package leetcode.normal.j699;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/falling-squares/submissions/
 * 699. 掉落的方块
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    static class TreeNode {
        public int left, right, height, lazyHeight;

        TreeNode(int l, int r, int h) {
            left = l;
            right = r;
            height = h;
            lazyHeight = 0;
        }
    }

    TreeNode[] tree;

    void build(int left, int right, int pos) {
        tree[pos] = new TreeNode(left, right, 0);
        if (left == right) {
            return;
        }
        int mid = (left + right) >> 1;
        if (left <= mid) build(left, mid, pos << 1);
        if (mid < right) build(mid + 1, right, (pos << 1) | 1);
    }

    void pushDown(int pos) {
        if (tree[pos].lazyHeight > 0) {
            tree[pos].height = tree[pos].lazyHeight;
            if (tree[pos].left != tree[pos].right) {
                tree[pos << 1].lazyHeight = tree[(pos << 1) | 1].lazyHeight = tree[pos].lazyHeight;
            }
            tree[pos].lazyHeight = 0;
        }
    }

    void pushUp(int pos) {
        tree[pos].height = Math.max(tree[pos << 1].height, tree[(pos << 1) | 1].height);
    }

    int getMax(int left, int right, int pos) {
        pushDown(pos);
        if (left <= tree[pos].left && tree[pos].right <= right) {
            return tree[pos].height;
        }
        int mid = (tree[pos].left + tree[pos].right) >> 1;
        int leftMax = 0, rightMax = 0;
        if (left <= mid) {
            leftMax = getMax(left, right, pos << 1);
        }
        if (mid < right) {
            rightMax = getMax(left, right, (pos << 1) | 1);
        }
        pushUp(pos);
        return Math.max(leftMax, rightMax);
    }

    void update(int left, int right, int height, int pos) {
        pushDown(pos);
        if (left <= tree[pos].left && tree[pos].right <= right) {
            tree[pos].height = tree[pos].lazyHeight = height;
            return;
        }
        int mid = (tree[pos].left + tree[pos].right) >> 1;
        if (left <= mid) update(left, right, height, pos << 1);
        if (mid < right) update(left, right, height, (pos << 1) | 1);
        pushUp(pos);
    }

    public List<Integer> fallingSquares(int[][] positions) {
        TreeSet<Integer> tSet = new TreeSet<>();
        for (int[] position : positions) {
            tSet.add(position[0]);
            tSet.add(position[0] + position[1] - 1);
        }
        TreeMap<Integer, Integer> nMap = new TreeMap<>();
        tSet.forEach(x -> nMap.put(x, nMap.size()));
        tree = new TreeNode[tSet.size() << 2];
        build(0, nMap.size() - 1, 1);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int[] position : positions) {
            int leftPos = nMap.get(position[0]);
            int rightPos = nMap.get(position[0] + position[1] - 1);
            int max = getMax(leftPos, rightPos, 1);
            update(leftPos, rightPos, max + position[1], 1);
            ans.add(getMax(0, nMap.size() - 1, 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] positions = {{1, 2}, {2, 3}, {6, 1}};
        System.out.println(solution.fallingSquares(positions));

    }
}