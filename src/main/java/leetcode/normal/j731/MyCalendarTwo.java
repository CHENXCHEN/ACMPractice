package leetcode.normal.j731;

import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/my-calendar-ii/">731. 我的日程安排表 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class MyCalendarTwo {
    TreeMap<Integer, Integer> tMap = new TreeMap<>();

    public MyCalendarTwo() {
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> floorStart = tMap.floorEntry(start);
        Map.Entry<Integer, Integer> floorEnd = tMap.floorEntry(end);
        if (floorStart != null && floorStart.getValue() == 2) return false;
        SortedMap<Integer, Integer> sub = tMap.subMap(start, end);
        for (Integer cnt : sub.values()) {
            if (cnt == 2) return false;
        }
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(sub.entrySet());
        for (Map.Entry<Integer, Integer> entry : entries) {
            tMap.put(entry.getKey(), entry.getValue() + 1);
        }
        if (floorStart == null) {
            tMap.put(start, 1);
        } else if (floorStart.getKey() < start) {
            tMap.put(start, floorStart.getValue() + 1);
        }
        if (floorEnd == null) {
            tMap.put(end, 0);
        } else if (floorEnd.getKey() < end) {
            tMap.put(end, floorEnd.getValue());
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */