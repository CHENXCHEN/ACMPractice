package leetcode.normal.j925;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/largest-component-size-by-common-factor/">952. 按公因数计算最大组件大小</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int largestComponentSize(int[] nums) {
        // 因为数字最大为 100000，其大于1个质因数个数的，质因子不超过 317，如果某个数超过 317 且为质数，那么必然不是这些的约数，如果都不能被这些整除，那么它本身就是一个质数
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317};
        int maxNum = Arrays.stream(nums).max().getAsInt() + 1;
        int numLen = nums.length;
        int[] parent = new int[numLen + maxNum];
        for (int i = 0; i < parent.length; i++) parent[i] = i;
        for (int i = 0; i < numLen; i++) {
            for (int prime : primes) {
                if (nums[i] < prime) break;
                if (nums[i] % prime != 0) continue;
                while (nums[i] % prime == 0) nums[i] /= prime;
                connect(parent, numLen + prime, i);
            }
            if (nums[i] != 1) connect(parent, numLen + nums[i], i);
        }
        int[] has = new int[numLen + maxNum];
        int ans = 0;
        for (int i = 0; i < numLen; i++) {
            int p = find(parent, i);
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