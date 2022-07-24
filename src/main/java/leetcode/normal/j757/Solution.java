package leetcode.normal.j757;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/set-intersection-size-at-least-two/">757. 设置交集大小至少为2</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            return o2[1] - o1[1];
        });
        TreeSet<Integer> ansSet = new TreeSet<>();
        int n = intervals.length;
        for (int i = n - 1; i >= 0; i--) {
            SortedSet<Integer> subSet = ansSet.subSet(intervals[i][0], true, intervals[i][1], true);
            if (subSet.size() >= 2) continue;
            int need = 2 - subSet.size();
            for (int j = 0, cnt = 0; cnt < need; j++) {
                if (ansSet.add(intervals[i][0] + j)) ++cnt;
            }
        }
        return ansSet.size();
    }
}