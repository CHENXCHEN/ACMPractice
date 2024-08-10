package leetcode.normal.j2940;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-building-where-alice-and-bob-can-meet/description/">2940. 找到 Alice 和 Bob 可以相遇的建筑</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution2 {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length, m = queries.length;
        ArrayList<int[]>[] query = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            query[i] = new ArrayList<>();
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int u = queries[i][0], v = queries[i][1];
            if (u > v) {
                u = queries[i][1];
                v = queries[i][0];
            }
            if (heights[u] < heights[v] || u == v) ans[i] = v;
            else {
                query[v].add(new int[]{i, heights[u]});
            }
        }
        ArrayList<Integer> stack = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            for (int[] rt : query[i]) {
                int idx = rt[0], h = rt[1];
                if (stack.isEmpty() || heights[stack.get(0)] <= h) ans[idx] = -1;
                else {
                    int left = 0, right = stack.size() - 1, res = -1;
                    while (left <= right) {
                        int mid = (left + right) >> 1;
                        if (heights[stack.get(mid)] > h) {
                            res = stack.get(mid);
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }
                    ans[idx] = res;
                }
            }
            while (!stack.isEmpty() && heights[stack.get(stack.size() - 1)] <= heights[i]) {
                stack.remove(stack.size() - 1);
            }
            stack.add(i);
        }
        return ans;
    }
}
