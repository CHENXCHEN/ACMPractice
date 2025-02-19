package leetcode.normal.j624;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-distance-in-arrays/description/">624. 数组列表中的最大距离</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    List<List<Integer>> arrays = new ArrayList<>();

    public int maxDistance(List<List<Integer>> arrays) {
        this.arrays = arrays;
        PriorityQueue<Integer> minPq = new PriorityQueue<>((x, y) -> getFirst(x) - getFirst(y)), maxPq = new PriorityQueue<>((x, y) -> getLast(y) - getLast(x));
        for (int i = 0; i < arrays.size(); i++) {
            minPq.add(i);
            maxPq.add(i);
        }
        int[] min = {minPq.poll(), minPq.poll()};
        int[] max = {maxPq.poll(), maxPq.poll()};
        int firstMin = getFirst(min[0]), secondMin = getFirst(min[1]);
        int firstMax = getLast(max[0]), secondMax = getLast(max[1]);
        if (min[0] != max[0]) return firstMax - firstMin;
        else return Math.max(secondMax - firstMin, firstMax - secondMin);
    }

    int getFirst(int idx) {
        return arrays.get(idx).get(0);
    }

    int getLast(int idx) {
        return arrays.get(idx).get(arrays.get(idx).size() - 1);
    }
}