package leetcode.normal.j715;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/range-module/
 * 715. Range 模块
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class RangeModule2 {
    // 记录 l -> r，表示 [l,r) 区间被跟踪
    // 每次操作必须要保证 li < ri < lj < rj && i < j
    TreeMap<Integer, Integer> tMap = new TreeMap<>();

    Map.Entry<Integer, Integer> getStartEntry(int left) {
        Map.Entry<Integer, Integer> startEntry = tMap.floorEntry(left);
        // 如果没有比 left 小的，或者 左区间在 left 之前
        // 调整 startEntry
        if (startEntry == null || startEntry.getValue() < left) startEntry = tMap.ceilingEntry(left);
        return startEntry;
    }

    public void addRange(int left, int right) {
        Map.Entry<Integer, Integer> startEntry = getStartEntry(left);
        // li <= left < right <= ri
        if (startEntry != null && startEntry.getKey() <= left && startEntry.getValue() >= right) return;
        // li <= left < ri < right
        // left < li < ri < right
        // left < li < right < ri
        // 调整 startEntry
        if (startEntry == null || startEntry.getValue() < left) startEntry = tMap.ceilingEntry(left);
        else left = Math.min(left, startEntry.getKey());
        while (startEntry != null && startEntry.getKey() <= right) {
            right = Math.max(right, startEntry.getValue());
            tMap.remove(startEntry.getKey());
            startEntry = tMap.higherEntry(startEntry.getKey());
        }
        tMap.put(left, right);
    }

    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> startEntry = tMap.floorEntry(left);
        return startEntry != null && startEntry.getValue() >= right;
    }

    public void removeRange(int left, int right) {
        Map.Entry<Integer, Integer> startEntry = getStartEntry(left);
        if (startEntry != null && startEntry.getKey() < left) {
            tMap.remove(startEntry.getKey());
            tMap.put(startEntry.getKey(), left);
            if (startEntry.getValue() > right) {
                tMap.put(right, startEntry.getValue());
            }
            startEntry = tMap.ceilingEntry(left);
        }
        while (startEntry != null && startEntry.getKey() < right) {
            if (startEntry.getValue() <= right) {
                tMap.remove(startEntry.getKey());
                startEntry = tMap.higherEntry(startEntry.getKey());
            } else {
                tMap.put(right, startEntry.getValue());
                tMap.remove(startEntry.getKey());
                break;
            }
        }
    }

    public static void main(String[] args) {
        RangeModule2 rangeModule2 = new RangeModule2();
//        rangeModule2.addRange(10, 20);
//        rangeModule2.removeRange(14, 16);
//        rangeModule2.queryRange(16, 17);

        rangeModule2.addRange(5, 8);
        rangeModule2.removeRange(5, 6);
        rangeModule2.removeRange(3, 6);
        rangeModule2.addRange(1, 3);
        rangeModule2.queryRange(2, 3);
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */