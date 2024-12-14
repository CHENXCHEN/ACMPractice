package leetcode.normal.j1338;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/reduce-array-size-to-the-half/description/">1338. 数组大小减半</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : arr) {
            cnt.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }
        ArrayList<Map.Entry<Integer, Integer>> keys = new ArrayList<>(cnt.entrySet());
        keys.sort((x, y) -> y.getValue() - x.getValue());
        int res = 0, n = arr.length, ans = 0;
        for (Map.Entry<Integer, Integer> entry : keys) {
            res += entry.getValue();
            ans++;
            if (res * 2 >= n) break;
        }
        return ans;
    }
}