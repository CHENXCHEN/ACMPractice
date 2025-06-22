package leetcode.normal.j683;

import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/k-empty-slots/description/">683. K 个关闭的灯泡</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int kEmptySlots(int[] bulbs, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < bulbs.length; i++) {
            set.add(bulbs[i]);
            Integer lower = set.lower(bulbs[i]);
            if (lower != null && bulbs[i] - lower - 1 == k) {
                return i + 1;
            }
            Integer higher = set.higher(bulbs[i]);
            if (higher != null && higher - bulbs[i] - 1 == k) {
                return i + 1;
            }
        }
        return -1;
    }
}