package leetcode.normal.j3072;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/distribute-elements-into-two-arrays-ii/description/">3072. 将元素分配到两个数组中 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    static class IndexedTree {
        int[] tree;

        IndexedTree(int n) {
            tree = new int[n + 1];
        }

        void add(int i) {
            while (i < tree.length) {
                tree[i]++;
                i += i & -i;
            }
        }

        int get(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }
    }

    public int[] resultArray(int[] nums) {
        int n = nums.length;
        ArrayList<Integer>[] arr = new ArrayList[2];
        IndexedTree[] idxTree = new IndexedTree[2];
        for (int i = 0; i < 2; i++) arr[i] = new ArrayList<>();
        for (int i = 0; i < 2; i++) idxTree[i] = new IndexedTree(n);
        Map<Integer, Integer> idx = new HashMap<>();
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        for (int i = 0; i < n; i++) {
            idx.computeIfAbsent(sorted[i], (kk) -> idx.size() + 1);
        }
        addItem(arr[0], idxTree[0], nums[0], idx.get(nums[0]));
        addItem(arr[1], idxTree[1], nums[1], idx.get(nums[1]));
        for (int i = 2; i < n; i++) {
            int sz1 = arr[0].size() - idxTree[0].get(idx.get(nums[i]));
            int sz2 = arr[1].size() - idxTree[1].get(idx.get(nums[i]));
            if (sz1 > sz2 || (sz1 == sz2 && arr[0].size() <= arr[1].size())) {
                addItem(arr[0], idxTree[0], nums[i], idx.get(nums[i]));
            } else {
                addItem(arr[1], idxTree[1], nums[i], idx.get(nums[i]));
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < arr[0].size(); i++) {
            ans[i] = arr[0].get(i);
        }
        for (int i = arr[0].size(), j = 0; i < n; i++, j++) {
            ans[i] = arr[1].get(j);
        }
        return ans;
    }

    void addItem(ArrayList<Integer> arr, IndexedTree idxTree, Integer item, Integer idx) {
        arr.add(item);
        idxTree.add(idx);
    }

}