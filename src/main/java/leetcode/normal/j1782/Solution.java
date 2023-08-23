package leetcode.normal.j1782;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-pairs-of-nodes/">1782. 统计点对的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] du = new int[n];
        Map<Pair<Integer, Integer>, Integer> cnt = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0] - 1, y = edge[1] - 1;
            if (x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            ++du[x];
            ++du[y];
            Pair<Integer, Integer> cur = new Pair<>(x, y);
            cnt.put(cur, cnt.getOrDefault(cur, 0) + 1);
        }
        int[] arr = Arrays.copyOf(du, n);
        Arrays.sort(arr);
        int[] ans = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int bound = queries[q], tot = 0;
            for (int i = 0; i < n; i++) {
                // 获得 i 右边可以跟 i 组成的数
                int j = binarySearch(arr, i + 1, n - 1, bound - arr[i]);
                tot += n - j;
            }
            for (Map.Entry<Pair<Integer, Integer>, Integer> entry : cnt.entrySet()) {
                Pair<Integer, Integer> key = entry.getKey();
                // 减去存在的共同的边
                if (du[key.getKey()] + du[key.getValue()] > bound && du[key.getKey()] + du[key.getValue()] - entry.getValue() <= bound) {
                    tot--;
                }
            }
            ans[q] = tot;
        }
        return ans;
    }

    int binarySearch(int[] arr, int left, int right, int target) {
        int ans = right + 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}