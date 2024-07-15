package leetcode.normal.j721;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/accounts-merge/description/">721. 账户合并</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] parent;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        parent = new int[n];
        TreeMap<String, Integer> has = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                Integer y = has.get(account.get(j));
                if (y == null) {
                    has.put(account.get(j), i);
                } else {
                    merge(i, y);
                }
            }
        }
        TreeSet<String>[] res = new TreeSet[n];
        for (int i = 0; i < n; i++) {
            int pos = find(i);
            List<String> account = accounts.get(i);
            if (res[pos] == null) res[pos] = new TreeSet<>();
            for (int j = 1; j < account.size(); j++) {
                res[pos].add(account.get(j));
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (res[i] != null) {
                ArrayList<String> list = new ArrayList<>();
                list.add(accounts.get(i).get(0));
                list.addAll(res[i]);
                ans.add(list);
            }
        }
        return ans;
    }

    void merge(int x, int y) {
        int fx = find(x), fy = find(y);
        parent[fx] = fy;
    }

    int find(int x) {
        return parent[x] != x ? (parent[x] = find(parent[x])) : x;
    }

    Integer getContain(TreeMap<String, Integer> has, List<String> account) {
        for (int i = 1; i < account.size(); i++) {
            Integer pos = has.get(account.get(i));
            if (pos != null) return pos;
        }
        return null;
    }
}