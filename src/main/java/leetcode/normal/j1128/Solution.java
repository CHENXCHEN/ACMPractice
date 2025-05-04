package leetcode.normal.j1128;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-equivalent-domino-pairs/description/">1128. 等价多米诺骨牌对的数量</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Pair<Integer, Integer>, Integer> cnt = new HashMap<>();
        int ans = 0;
        for (int[] domino : dominoes) {
            Arrays.sort(domino);
            Pair<Integer, Integer> cur = new Pair<>(domino[0], domino[1]);
            Integer num = cnt.getOrDefault(cur, 0);
            ans += num;
            cnt.put(cur, num + 1);
        }
        return ans;
    }
}