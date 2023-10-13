package leetcode.normal.j1488;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/avoid-flood-in-the-city/description/">1488. 避免洪水泛滥</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] avoidFlood(int[] rains) {
        TreeSet<Integer> emptyPos = new TreeSet<>();
        HashMap<Integer, Integer> rainPos = new HashMap<>();
        int[] ans = new int[rains.length];
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] > 0) {
                ans[i] = -1;
                Integer prePos = rainPos.get(rains[i]);
                if (prePos != null) {
                    Integer higher = emptyPos.higher(prePos);
                    if (higher != null) {
                        emptyPos.remove(higher);
                        ans[higher] = rains[i];
                    } else {
                        ans = new int[0];
                        return ans;
                    }
                }
                rainPos.put(rains[i], i);
            } else {
                emptyPos.add(i);
                ans[i] = 1;
            }
        }
        return ans;
    }
}