package leetcode.normal.j781;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numRabbits(int[] answers) {
        int n = answers.length;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int answer : answers) {
            cnt.compute(answer, (k, v) -> v == null ? 1 : v + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int key = entry.getKey() + 1;
            ans += entry.getValue() / key * key;
            if (entry.getValue() % key != 0) {
                ans += key;
            }
        }
        return ans;
    }
}