package leetcode.normal.j57;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/insert-interval/">57. 插入区间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ret = new ArrayList<>();
        boolean found = false;
        for (int[] interval : intervals) {
            if (newInterval != null) {
                if (interval[1] < newInterval[0]) {
                    ret.add(interval);
                } else if (isIntersect(interval, newInterval)) {
                    newInterval[0] = Math.min(newInterval[0], interval[0]);
                    newInterval[1] = Math.max(newInterval[1], interval[1]);
                } else {
                    ret.add(newInterval);
                    ret.add(interval);
                    newInterval = null;
                }
            } else {
                ret.add(interval);
            }
        }
        if (newInterval != null) ret.add(newInterval);
        int[][] ans = new int[ret.size()][2];
        for (int i = 0; i < ret.size(); i++) {
            ans[i] = ret.get(i);
        }
        return ans;
    }

    boolean isIntersect(int[] line1, int[] line2) {
        return (line1[0] <= line2[0] && line2[0] <= line1[1]) ||
                (line1[0] <= line2[1] && line2[1] <= line1[1]) ||
                (line2[0] <= line1[0] && line1[0] <= line2[1]) ||
                (line2[0] <= line1[1] && line1[1] <= line2[1])
                ;
    }
}