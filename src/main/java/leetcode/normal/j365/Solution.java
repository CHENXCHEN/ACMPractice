package leetcode.normal.j365;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/water-and-jug-problem/description/">365. 水壶问题</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int cap1, cap2, target;

    Set<Pair<Integer, Integer>> visit;

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        cap1 = jug1Capacity;
        cap2 = jug2Capacity;
        target = targetCapacity;
        visit = new HashSet<>();
        return dfs(new Pair<>(0, 0));
    }

    boolean dfs(Pair<Integer, Integer> pair) {
        if (pair.getKey() == target || pair.getValue() == target || pair.getKey() + pair.getValue() == target) return true;
        if (visit.contains(pair)) return false;
        visit.add(pair);
        // 将左边清空
        if (dfs(new Pair<>(0, pair.getValue()))) return true;
        // 将右边清空
        if (dfs(new Pair<>(pair.getKey(), 0))) return true;
        // 将左边加满
        if (dfs(new Pair<>(cap1, pair.getValue()))) return true;
        // 将右边加满
        if (dfs(new Pair<>(pair.getKey(), cap2))) return true;
        // 将左边倒到右边
        int valid1 = Math.min(cap2 - pair.getValue(), pair.getKey());
        if (dfs(new Pair<>(pair.getKey() - valid1, pair.getValue() + valid1))) return true;
        // 将右边倒到左边
        int valid2 = Math.min(cap1 - pair.getKey(), pair.getValue());
        if (dfs(new Pair<>(pair.getKey() + valid2, pair.getValue() - valid2))) return true;
        return false;
    }
}