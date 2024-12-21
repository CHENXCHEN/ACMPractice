package leetcode.normal.j1847;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/closest-room/description/">1847. 最近的房间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    static class Event {
        int tp, roomId, size, queryIdx;

        public Event(int tp, int roomId, int size, int queryIdx) {
            this.tp = tp;
            this.roomId = roomId;
            this.size = size;
            this.queryIdx = queryIdx;
        }
    }

    public int[] closestRoom(int[][] rooms, int[][] queries) {
        // 要求找到距离某个 roomId 最近的至少 >= minSize 的房间 id，如果有相同，则取最小 roomId
        // 本题的关键在于查询的 roomId，面积只要大于最小值即可
        // 若我们先固定其中一个维度，比如先对面积进行降序处理，再依次考虑哪些 roomId 符合条件
        ArrayList<Event> events = new ArrayList<>();
        for (int i = 0; i < rooms.length; i++) {
            events.add(new Event(0, rooms[i][0], rooms[i][1], i));
        }
        for (int i = 0; i < queries.length; i++) {
            events.add(new Event(1, queries[i][0], queries[i][1], i));
        }
        // 先按照房间面积降序，再按照 roomId 升序，再按照 tp 升序
        events.sort((x, y) -> {
            if (x.size != y.size) return y.size - x.size;
            return x.tp - y.tp;
        });
        TreeSet<Integer> valid = new TreeSet<>();
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        for (Event event : events) {
            if (event.tp == 0) {
                valid.add(event.roomId);
            } else {
                Integer higher = valid.ceiling(event.roomId);
                Integer lower = valid.floor(event.roomId);
                // 取距离 rootId 最小的那个
                // higher - roomId vs roomId - lower
                int dis = Integer.MAX_VALUE;
//                System.out.printf("query: %s higher: %d lower: %d\n", event.queryIdx, higher, lower);
                if (lower != null && event.roomId - lower < dis) {
                    ans[event.queryIdx] = lower;
                    dis = event.roomId - lower;
                }
                if (higher != null && higher - event.roomId < dis) {
                    ans[event.queryIdx] = higher;
                }
            }
        }
        return ans;
    }
}