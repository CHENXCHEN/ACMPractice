package leetcode.normal.j253;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/meeting-rooms-ii/">253. 会议室 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        for (int[] interval : intervals) {
            tMap.put(interval[0], tMap.getOrDefault(interval[0], 0) + 1);
            tMap.put(interval[1], tMap.getOrDefault(interval[1], 0) - 1);
        }
        int start = 0, ans = 0;
        for (Map.Entry<Integer, Integer> entry : tMap.entrySet()) {
            start += entry.getValue();
            ans = Math.max(start, ans);
        }
        return ans;
    }
}