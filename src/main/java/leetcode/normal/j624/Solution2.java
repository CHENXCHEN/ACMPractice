package leetcode.normal.j624;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-distance-in-arrays/description/">624. 数组列表中的最大距离</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    List<List<Integer>> arrays = new ArrayList<>();

    public int maxDistance(List<List<Integer>> arrays) {
        this.arrays = arrays;
        int ans = 0, min = getFirst(0), max = getLast(0);
        for (int i = 1; i < arrays.size(); i++) {
            // 每个回合，分别用当前的最小值和过往的最大值，当前和最大值和过往的最小值计算
            int curMin = getFirst(i), curMax = getLast(i);
            ans = Math.max(ans, Math.max(Math.abs(curMax - min), Math.abs(max - curMin)));
            min = Math.min(curMin, min);
            max = Math.max(curMax, max);
        }
        return ans;
    }

    int getFirst(int idx) {
        return arrays.get(idx).get(0);
    }

    int getLast(int idx) {
        return arrays.get(idx).get(arrays.get(idx).size() - 1);
    }
}