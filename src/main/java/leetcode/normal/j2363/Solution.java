package leetcode.normal.j2363;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/merge-similar-items/">2363. 合并相似的物品</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        for (int[] item : items1) {
            tMap.put(item[0], item[1]);
        }
        for (int[] item : items2) {
            tMap.compute(item[0], (k, v) -> (v == null ? 0 : v) + item[1]);
        }
        return tMap.entrySet().stream()
                .map(x -> Arrays.asList(x.getKey(), x.getValue()))
                .collect(Collectors.toList());
    }
}