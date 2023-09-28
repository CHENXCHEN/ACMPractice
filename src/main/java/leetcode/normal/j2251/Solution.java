package leetcode.normal.j2251;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-flowers-in-full-bloom/">2251. 花期内花的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        Integer[] pos = new Integer[people.length];
        for (int i = 0; i < people.length; i++) pos[i] = i;
        Arrays.sort(pos, (x, y) -> Integer.compare(people[x], people[y]));
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        for (int[] flower : flowers) {
            tMap.put(flower[0], tMap.getOrDefault(flower[0], 0) + 1);
            tMap.put(flower[1] + 1, tMap.getOrDefault(flower[1] + 1, 0) - 1);
        }
        int totFlowers = 0, idx = 0;
        int[] ans = new int[people.length];
        Arrays.fill(ans, -1);
        for (Map.Entry<Integer, Integer> entry : tMap.entrySet()) {
            if (idx >= people.length) break;
            while (idx < people.length && entry.getKey() > people[pos[idx]]) {
                ans[pos[idx]] = totFlowers;
                idx++;
            }
            totFlowers += entry.getValue();
        }
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == -1) ans[i] = totFlowers;
        }
        return ans;
    }
}