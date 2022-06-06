package leetcode.normal.j732;

import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/my-calendar-iii/
 * 732. 我的日程安排表 III
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class MyCalendarThree {
    int ans;
    TreeMap<Integer, Integer> tMap;

    public MyCalendarThree() {
        ans = 0;
        tMap = new TreeMap<>();
    }

    public int book(int start, int end) {
        Map.Entry<Integer, Integer> floorStart = tMap.floorEntry(start);
        Map.Entry<Integer, Integer> floorEnd = tMap.floorEntry(end);
        int tmp = (floorStart == null ? 0 : floorStart.getValue()) + 1;
        SortedMap<Integer, Integer> subMap = tMap.subMap(start, end);
        ArrayList<Map.Entry<Integer, Integer>> needRemove = new ArrayList<>(subMap.entrySet());
        tMap.putIfAbsent(start, tmp);
        for (Map.Entry<Integer, Integer> entry : needRemove) {
            tmp = Math.max(tmp, entry.getValue() + 1);
            tMap.put(entry.getKey(), entry.getValue() + 1);
        }
        tMap.putIfAbsent(end, floorEnd == null ? 0 : floorEnd.getValue());
        ans = Math.max(ans, tmp);
        return ans;
    }

    public static void main(String[] args) {
        MyCalendarThree myCalendarThree = new MyCalendarThree();
        myCalendarThree.book(10, 20);
        myCalendarThree.book(50, 60);
        myCalendarThree.book(10, 40);
        myCalendarThree.book(5, 15);
        myCalendarThree.book(5, 10);
        myCalendarThree.book(25, 55);
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */