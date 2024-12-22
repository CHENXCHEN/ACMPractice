package leetcode.normal.j1387;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/sort-integers-by-the-power-value/description/">1387. 将整数按权重排序</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    TreeMap<Integer, Integer> mem;

    public int getKth(int lo, int hi, int k) {
        mem = new TreeMap<>();
        Integer[] res = new Integer[hi - lo + 1], pos = new Integer[hi - lo + 1];
        for (int i = lo, j = 0; i <= hi; i++, j++) {
            res[j] = getStep(i);
            pos[j] = j;
        }
        Arrays.sort(pos, (x, y) -> res[x] != res[y] ? res[x] - res[y] : x - y);
        return pos[k - 1] + lo;
    }

    int getStep(int x) {
        if (x == 1) return 0;
        if (mem.containsKey(x)) return mem.get(x);
        mem.put(x, ((x & 1) == 0 ? getStep(x >> 1) : getStep(x * 3 + 1)) + 1);
        return mem.get(x);
    }
}