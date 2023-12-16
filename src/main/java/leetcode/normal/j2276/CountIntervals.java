package leetcode.normal.j2276;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-integers-in-intervals/description/">2276. 统计区间中的整数数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class CountIntervals {
    // 表示 [key, value] 是包含的
    TreeMap<Integer, Integer> tMap;
    int size;

    public CountIntervals() {
        tMap = new TreeMap<>();
        size = 0;
    }

    public void add(int left, int right) {
        Map.Entry<Integer, Integer> entry = tMap.floorEntry(right);
        while (entry != null && entry.getValue() >= left) {
            left = Math.min(left, entry.getKey());
            right = Math.max(right, entry.getValue());
            size -= entry.getValue() - entry.getKey() + 1;
            tMap.remove(entry.getKey());
            entry = tMap.floorEntry(right);
        }
        tMap.put(left, right);
        size += right - left + 1;
    }

    public int count() {
        return size;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */