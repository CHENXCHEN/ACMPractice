package leetcode.normal.j1090;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/largest-values-from-labels/">1090. 受标签影响的最大值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int n = values.length;
        Integer[] pos = new Integer[n];
        for (int i = 0; i < n; i++) pos[i] = i;
        Arrays.sort(pos, (x, y) -> values[y] - values[x]);
        int ans = 0, tot = 0;
        for (int i = 0; i < n && tot < numWanted; i++) {
            int cur = pos[i];
            Integer labelCnt = cnt.getOrDefault(labels[cur], 0);
            if (labelCnt < useLimit) {
                cnt.put(labels[cur], labelCnt + 1);
                ans += values[cur];
                ++tot;
            }
        }
        return ans;
    }
}