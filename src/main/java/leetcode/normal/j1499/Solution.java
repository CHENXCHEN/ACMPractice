package leetcode.normal.j1499;

import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/max-value-of-equation/">1499. 满足不等式的最大值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        TreeMap<Integer, Integer> cnt = new TreeMap<>();
        int left = 0, right = 1, n = points.length;
        cnt.put(calcPoint(points[0]), 1);
        int ans = Integer.MIN_VALUE;
        while (right < n) {
            while (left < right && points[right][0] - points[left][0] > k) {
                int leftSpecial = calcPoint(points[left]);
                int leave = cnt.get(leftSpecial) - 1;
                if (leave == 0) cnt.remove(leftSpecial);
                else cnt.put(leftSpecial, leave);
                left++;
            }
            if (cnt.size() > 0) {
                ans = Math.max(ans, cnt.lastEntry().getKey() + points[right][0] + points[right][1]);
            }
            int rightSpecial = calcPoint(points[right]);
            cnt.put(rightSpecial, cnt.getOrDefault(rightSpecial, 0) + 1);
            ++right;
        }
        return ans;
    }

    int calcPoint(int[] point) {
        return point[1] - point[0];
    }
}