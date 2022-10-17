package leetcode.normal.j904;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/fruit-into-baskets/">904. 水果成篮</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int totalFruit(int[] fruits) {
        Set<Integer> set = new HashSet<>();
        int ans = 0, cnt = 0;
        int i = 0, n = fruits.length, lastIdx = 0;
        while (i < n) {
            while (i < n && (set.contains(fruits[i]) || set.size() < 2)) {
                set.add(fruits[i]);
                if (fruits[lastIdx] != fruits[i]) lastIdx = i;
                ++cnt;
                ++i;
            }
            if (cnt > ans) ans = cnt;
            if (i == n) break;
            cnt = i - lastIdx;
            set.clear();
            set.add(fruits[lastIdx]);
        }
        return ans;
    }
}