package leetcode.normal.j2736;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-sum-queries/description/">2736. 最大和查询</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length, m = queries.length;
        int[][] sortNums = new int[n][2];
        int[][] sortQueries = new int[m][3];
        for (int i = 0; i < n; i++) {
            sortNums[i][0] = nums1[i];
            sortNums[i][1] = nums2[i];
        }
        for (int i = 0; i < m; i++) {
            sortQueries[i][0] = queries[i][0];
            sortQueries[i][1] = queries[i][1];
            sortQueries[i][2] = i;
        }
        Arrays.sort(sortNums, (x, y) -> Integer.compare(y[0], x[0]));
        Arrays.sort(sortQueries, (x, y) -> Integer.compare(y[0], x[0]));
        ArrayList<int[]> stack = new ArrayList<>();
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        int i = 0;
        for (int[] query : sortQueries) {
            int x = query[0], y = query[1], idx = query[2];
            while (i < n && sortNums[i][0] >= x) {
                int ss = sortNums[i][0] + sortNums[i][1];
                while (!stack.isEmpty() && stack.get(stack.size() - 1)[1] <= ss) {
                    stack.remove(stack.size() - 1);
                }
                if (stack.isEmpty() || stack.get(stack.size() - 1)[0] < sortNums[i][1]) {
                    stack.add(new int[]{sortNums[i][1], ss});
                }
                i++;
            }
            int k = binarySearch(stack, y);
            if (k != -1) {
                ans[idx] = stack.get(k)[1];
            }
        }
        return ans;
    }

    int binarySearch(ArrayList<int[]> stack, int target) {
        int ans = -1, left = 0, right = stack.size() - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (stack.get(mid)[0] >= target) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return ans;
    }
}