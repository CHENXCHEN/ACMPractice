package leetcode.normal.j2007;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-original-array-from-doubled-array/description/">2007. 从双倍数组中还原原数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        TreeMap<Integer, Integer> cnt = new TreeMap<>();
        int[] ans = new int[changed.length >> 1];
        int idx = 0;
        for (int v : changed) {
            boolean remove = false;
            if ((v & 1) == 0) {
                int before = v >> 1;
                int res = cnt.getOrDefault(before, 0);
                if (res > 0) {
                    remove = true;
                    cnt.compute(before, (kk, vv) -> vv - 1);
                    if (res - 1 == 0) cnt.remove(before);
                    if (idx >= ans.length) return new int[]{};
                    ans[idx++] = before;
                }
            }
            if (!remove) {
                cnt.compute(v, (kk, vv) -> vv == null ? 1 : vv + 1);
            }
        }
        if (!cnt.isEmpty()) return new int[]{};
        return ans;
    }
}