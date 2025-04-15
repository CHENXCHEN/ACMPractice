package leetcode.normal.j2179;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-good-triplets-in-an-array/description/">2179. 统计数组中好三元组数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] tree;

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        tree = new int[n + 1];
        // pos2 => nums2 中各个数字的位置
        // reversedIndexMapping => nums1 的各个数字在 nums2 中的位置
        int[] pos2 = new int[n], reversedIndexMapping = new int[n];
        for (int i = 0; i < n; i++) {
            pos2[nums2[i]] = i;
        }
        for (int i = 0; i < n; i++) {
            reversedIndexMapping[pos2[nums1[i]]] = i;
        }
        // 枚举 nums2 中的位置 j，其左边的数 * 其右边的数
        long ans = 0;
        for (int j = 0; j < n; j++) {
            int pos = reversedIndexMapping[j];
            int left = query(pos + 1);
            update(pos + 1, 1);
            // j - left 表示在 nums2 中左边且在 nums1 右边的数，这部分要排除掉
            int right = (n - 1 - pos) - (j - left);
            ans += (long) left * right;
        }
        return ans;
    }

    void update(int idx, int val) {
        while (idx < tree.length) {
            tree[idx] += val;
            idx += idx & -idx;
        }
    }

    int query(int idx) {
        int res = 0;
        while (idx > 0) {
            res += tree[idx];
            idx -= idx & -idx;
        }
        return res;
    }
}