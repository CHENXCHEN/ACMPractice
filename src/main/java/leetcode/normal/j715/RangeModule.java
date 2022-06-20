package leetcode.normal.j715;

import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/range-module/
 * 715. Range 模块
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class RangeModule {

    // value: 0 -> 该点右边为不跟踪
    // value: 1 -> 该点右边为跟踪
    TreeMap<Integer, Integer> tMap;

    public RangeModule() {
        tMap = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        Map.Entry<Integer, Integer> floorLeft = tMap.floorEntry(left - 1);
        Map.Entry<Integer, Integer> floorRight = tMap.floorEntry(right);
        ArrayList<Integer> needRemove = new ArrayList<>(tMap.subMap(left, right).keySet());
        for (Integer key : needRemove) {
            tMap.remove(key);
        }
        // 如果 left 左边是 0，那么 left 设置为 1
        if (floorLeft == null || floorLeft.getValue() == 0) {
            tMap.put(left, 1);
        }
        // 如果 right 为 0，那么要设置为 0
        if (floorRight == null || floorRight.getValue() == 0) {
            tMap.put(right, 0);
            // 将 right 右边紧挨着的 0 去除掉
            while (tMap.getOrDefault(right + 1, -1) == 0) {
                tMap.remove(right + 1);
                right++;
            }
        } else if (floorRight.getValue() == 1) {
            // 如果 right 为 1，那么 right 依然跟踪，将 right 删除
            tMap.remove(right);
        }
    }

    public boolean queryRange(int left, int right) {
        // 判断 left 是否有被跟踪
        Map.Entry<Integer, Integer> floorLeft = tMap.floorEntry(left);
        // 如果 left 没有被跟踪，那么返回 false
        if (floorLeft == null || floorLeft.getValue() == 0) return false;
        SortedMap<Integer, Integer> subMap = tMap.subMap(floorLeft.getKey(), right);
        // 如果 left 被跟踪了，那么 [left, right) 被跟踪，区间有且仅有1个点才是完全跟踪
        return subMap.size() == 1;
    }

    public void removeRange(int left, int right) {
        Map.Entry<Integer, Integer> floorLeft = tMap.floorEntry(left - 1);
        Map.Entry<Integer, Integer> floorRight = tMap.floorEntry(right);
        ArrayList<Integer> needRemove = new ArrayList<>(tMap.subMap(left, right).keySet());
        for (Integer key : needRemove) {
            tMap.remove(key);
        }
        // 如果 left 左边为 1，那么 [left, ...] 设置为 0
        if (floorLeft != null && floorLeft.getValue() == 1) {
            tMap.put(left, 0);
        }
        // 如果 right 被跟踪了，那么 [right, ...] 设置为 1
        if (floorRight != null && floorRight.getValue() == 1) {
            tMap.put(right, 1);
            while (tMap.getOrDefault(right + 1, -1) == 1) {
                tMap.remove(right + 1);
                right++;
            }
        }
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */