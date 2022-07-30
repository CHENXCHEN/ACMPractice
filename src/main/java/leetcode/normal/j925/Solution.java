package leetcode.normal.j925;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/largest-component-size-by-common-factor/">952. 按公因数计算最大组件大小</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int largestComponentSize(int[] nums) {
        int maxNum = nums[0];
        for (int num : nums) {
            if (num > maxNum) maxNum = num;
        }

        int[] parent = new int[maxNum + 1];
        for (int i = 0; i <= maxNum; i++) parent[i] = i;
        for (int num : nums) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    connect(parent, i, num);
                    connect(parent, i, num / i);
                }
            }
        }
        int[] has = new int[maxNum + 1];
        int ans = 0;
        for (int num : nums) {
            int p = find(parent, num);
            has[p]++;
            if (has[p] > ans) ans = has[p];
        }
        return ans;
    }

    int find(int[] parent, int p) {
        if (parent[p] != p)
            parent[p] = find(parent, parent[p]);
        return parent[p];
    }

    void connect(int[] parent, int from, int to) {
        int fromParent = find(parent, from);
        int toParent = find(parent, to);
        if (fromParent != toParent)
            parent[fromParent] = toParent;
    }
}