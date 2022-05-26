package leetcode.normal.j699;

import java.util.*;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/falling-squares/submissions/
 * 699. 掉落的方块
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public List<Integer> fallingSquares(int[][] positions) {
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int maxHeight = 0;
        for (int[] position : positions) {
            int left = position[0], right = position[0] + position[1] - 1;
            Map.Entry<Integer, Integer> floorLeft = tMap.floorEntry(left);
            Map.Entry<Integer, Integer> floorRight = tMap.floorEntry(right + 1);
            // 在 [left, right] 这个区间如果有交集，那么代表该方块可以叠上去
            // Notice: 需要注意 left 和 (right+1) 左边的第一个高度
            SortedMap<Integer, Integer> subMap = tMap.subMap(left, right + 1);
            int tmpHeight = floorLeft == null ? 0 : floorLeft.getValue();
            ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(subMap.entrySet());
            for (Map.Entry<Integer, Integer> entry : entries) {
                tmpHeight = Math.max(tmpHeight, entry.getValue());
                tMap.remove(entry.getKey());
            }
            int nowHeight = position[1] + tmpHeight;
            tMap.put(left, nowHeight);
            tMap.putIfAbsent(right + 1, floorRight == null ? 0 : floorRight.getValue());
            maxHeight = Math.max(maxHeight, nowHeight);
            ans.add(maxHeight);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
//        int[][] positions = {{1, 2}, {2, 3}, {6, 1}};
//        System.out.println(solution.fallingSquares(positions));
//        int[][] positions1 = {{2, 82}, {57, 22}, {16, 66}, {46, 15}, {5, 11}, {9, 83}, {1, 32}, {87, 91}, {64, 61}, {87, 53}};
        int[][] positions1 = {{33, 34}, {47, 62}, {70, 16}, {90, 79}, {73, 86}, {55, 6}, {74, 2}, {40, 95}, {52, 16}, {50, 33}};
        System.out.println(solution.fallingSquares(positions1));
    }
}