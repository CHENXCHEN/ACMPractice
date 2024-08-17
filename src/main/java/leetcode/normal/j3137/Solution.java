package leetcode.normal.j3137;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-operations-to-make-word-k-periodic/description/">3137. K 周期字符串需要的最少操作次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        int mx = 0;
        for (int i = 0; i < word.length(); i += k) {
            mx = Math.max(mx, cnt.compute(word.substring(i, i + k), (kk, vv) -> (vv == null ? 0 : vv) + 1));
        }
        return word.length() / k - mx;
    }
}