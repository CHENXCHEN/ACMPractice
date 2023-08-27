package leetcode.normal.j56;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/merge-intervals/">56. 合并区间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        int[] lastLine = null;
        Arrays.sort(intervals, (l1, l2) -> l1[0] != l2[0] ? Integer.compare(l1[0], l2[0]) : Integer.compare(l1[1], l2[1]));
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] line : intervals) {
            if (lastLine == null) {
                lastLine = line;
            } else if (isIntersect(lastLine, line)) {
                lastLine[1] = Math.max(lastLine[1], line[1]);
            } else {
                list.add(lastLine);
                lastLine = line;
            }
        }
        if (lastLine != null) list.add(lastLine);
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    boolean isIntersect(int[] left, int[] right) {
        return left[0] <= right[0] && right[0] <= left[1];
    }
}