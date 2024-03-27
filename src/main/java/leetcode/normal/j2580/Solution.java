package leetcode.normal.j2580;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-ways-to-group-overlapping-ranges/description/">2580. 统计将重叠区间合并成组的方案数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countWays(int[][] ranges) {
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        for (int[] range : ranges) {
            int left = range[0], right = range[1];
            Map.Entry<Integer, Integer> ltRight = tMap.floorEntry(right);
            while (ltRight != null && (ltRight.getValue() >= left)) {
                left = Math.min(left, ltRight.getKey());
                right = Math.max(right, ltRight.getValue());
                tMap.remove(ltRight.getKey());
//                System.out.println("remove: " + ltRight.getKey() + " " + ltRight.getValue());
                ltRight = tMap.floorEntry(right);
            }
//            System.out.println("put: " + left + " " + right);
            tMap.put(left, right);
        }
        int size = tMap.size();
        int ans = 1, mod = (int) 1e9 + 7;
        for (int i = 0; i < size; i++) {
            ans = (ans << 1) % mod;
        }
        return ans;
    }
}