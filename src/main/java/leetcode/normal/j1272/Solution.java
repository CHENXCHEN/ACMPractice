package leetcode.normal.j1272;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/remove-interval/description/">1272. 删除区间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[1] <= toBeRemoved[0] || interval[0] >= toBeRemoved[1]) {
                // 线段不相交
                ans.add(Arrays.asList(interval[0], interval[1]));
            } else {
                // 线段相交
                if (interval[0] < toBeRemoved[0]) {
                    // 如果线段在左边，且部分相交
                    ans.add(Arrays.asList(interval[0], toBeRemoved[0]));
                }
                if (interval[1] > toBeRemoved[1]) {
                    // 如果线段在右边，且部分相交
                    ans.add(Arrays.asList(toBeRemoved[1], interval[1]));
                }
            }
        }
        return ans;
    }
}