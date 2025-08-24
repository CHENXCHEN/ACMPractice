package leetcode.normal.j1182;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/shortest-distance-to-target-color/description/">1182. 与目标颜色间的最短距离</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        ArrayList<Integer>[] list = new ArrayList[4];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < colors.length; i++) {
            list[colors[i]].add(i);
        }
        List<Integer> ans = new ArrayList<>();
        for (int[] query : queries) {
            int pos = query[0];
            int color = query[1];
            int findPos = Collections.binarySearch(list[color], pos);
            if (findPos >= 0) {
                // 如果当前位置就是对应颜色
                ans.add(0);
            } else if (list[color].isEmpty()) {
                ans.add(-1);
            } else {
                // 如果当前位置不是对应颜色，找到对应插入的位置
                int insertPos = -findPos - 1;
                // 比当前位置小的前一个位置
                int prevPos = insertPos == 0 ? Integer.MAX_VALUE : list[color].get(insertPos - 1);
                // 比当前位置大的下一个位置
                int nextPos = insertPos == list[color].size() ? Integer.MAX_VALUE : list[color].get(insertPos);
                int res = Math.min(Math.abs(pos - prevPos), Math.abs(nextPos - pos));
                ans.add(res);
            }
        }
        return ans;
    }
}