package leetcode.normal.j2070;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/most-beautiful-item-for-each-query/description/">2070. 每一个查询的最大美丽值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < items.length; i++) {
            int price = items[i][0], beauty = items[i][1];
            max = Math.max(max, beauty);
            map.put(price, max);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int price = queries[i];
            Map.Entry<Integer, Integer> entry = map.floorEntry(price);
            if (entry != null) {
                ans[i] = entry.getValue();
            }
        }
        return ans;
    }
}