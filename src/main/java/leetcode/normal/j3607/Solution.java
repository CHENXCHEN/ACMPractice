package leetcode.normal.j3607;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/power-grid-maintenance/description/">3607. 电网维护</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] parent;

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        parent = new int[c + 1];
        for (int i = 0; i <= c; i++) {
            parent[i] = i;
        }
        for (int[] connection : connections) {
            union(connection[0], connection[1]);
        }
        HashMap<Integer, TreeSet<Integer>> ss = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int fa = find(i);
            ss.computeIfAbsent(fa, k -> new TreeSet<>()).add(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int[] query : queries) {
            int tp = query[0], vv = query[1];
            int key = find(vv);
            TreeSet<Integer> tSet = ss.get(key);
            if (tp == 1) {
                if (tSet != null && !tSet.isEmpty()) ans.add(tSet.contains(vv) ? vv : tSet.first());
                else ans.add(-1);
            } else {
                if (tSet != null && !tSet.isEmpty()) tSet.remove(vv);
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    void union(int u, int v) {
        int fu = find(u), fv = find(v);
        if (fu > fv) parent[fu] = fv;
        else parent[fv] = fu;
    }
}