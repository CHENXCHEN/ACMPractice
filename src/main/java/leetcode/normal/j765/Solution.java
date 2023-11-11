package leetcode.normal.j765;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/couples-holding-hands/description/">https://leetcode.cn/problems/couples-holding-hands/description/</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] parent;

    public int minSwapsCouples(int[] row) {
        int n = row.length;
        parent = new int[n >> 1];
        for (int i = 0; i < parent.length; i++) parent[i] = i;

        for (int i = 0; i < n; i += 2) {
            int pa = find(row[i] >> 1), pb = find(row[i + 1] >> 1);
            parent[pa] = pb;
        }
        int ans = parent.length;
        for (int i = 0; i < parent.length; i++) find(i);
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) --ans;
        }
//        int[] cnt = new int[n];
//        for (int i = 0; i < parent.length; i++) cnt[find(i)]++;
//        int ans = 0;
//        for (int i = 0; i < parent.length; i++) {
//            if (cnt[i] >= 2) ans += cnt[i] - 1;
//        }
        return ans;
    }

    int find(int x) {
        return x == parent[x] ? x : (parent[x] = find(parent[x]));
    }
}