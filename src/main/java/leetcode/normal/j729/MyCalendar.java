package leetcode.normal.j729;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/my-calendar-i/">729. 我的日程安排表 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class MyCalendar {
    TreeMap<Integer, Integer> tMap = new TreeMap<>();

    public MyCalendar() {
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> floorStart = tMap.floorEntry(start);
        Map.Entry<Integer, Integer> lowerEnd = tMap.lowerEntry(end);
        if (floorStart != null && floorStart.getValue() > start) {
            return false;
        }
        if (lowerEnd != null && lowerEnd.getValue() > start) {
            return false;
        }
        tMap.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */