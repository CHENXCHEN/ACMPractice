package leetcode.normal.j1817;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/finding-the-users-active-minutes/">1817. 查找用户活跃分钟数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer, Set<Integer>> mm = new HashMap<>();
        for (int[] log : logs) {
            if (!mm.containsKey(log[0])) mm.put(log[0], new HashSet<>());
            mm.get(log[0]).add(log[1]);
        }
        int[] ans = new int[k];
        for (Map.Entry<Integer, Set<Integer>> entry : mm.entrySet()) {
            ans[entry.getValue().size() - 1]++;
        }
        return ans;
    }
}