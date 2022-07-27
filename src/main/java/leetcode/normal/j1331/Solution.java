package leetcode.normal.j1331;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/rank-transform-of-an-array/">1331. 数组序号转换</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        int[] cp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(cp);
        Map<Integer, Integer> tMap = new HashMap<>();
        int tot = 1;
        tMap.put(cp[0], 1);
        for (int i = 1; i < cp.length; i++) {
            if (cp[i - 1] != cp[i]) {
                tMap.put(cp[i], ++tot);
            }
        }
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = tMap.get(arr[i]);
        }
        return ans;
    }
}