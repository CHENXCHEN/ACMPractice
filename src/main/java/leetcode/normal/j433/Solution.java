package leetcode.normal.j433;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/
 * 433. 最小基因变化
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int diffChange(String from, String to) {
        int cnt = 0;
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) != to.charAt(i)) cnt++;
        }
        return cnt;
    }

    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;
        TreeMap<String, Integer> tMap = new TreeMap<>();
        tMap.put(start, 0);
        tMap.put(end, 1);
        for (String item : bank) {
            tMap.put(item, tMap.getOrDefault(item, tMap.size()));
        }
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < tMap.size(); i++) edges.add(new ArrayList<>());
        for (int i = 0; i < bank.length; i++) {
            Integer fromNum = tMap.get(bank[i]);
            if (diffChange(start, bank[i]) == 1) {
                edges.get(0).add(fromNum);
                edges.get(fromNum).add(0);
            }
            for (int j = i + 1; j < bank.length; j++) {
                Integer toNum = tMap.get(bank[j]);
                if (diffChange(bank[i], bank[j]) == 1) {
                    edges.get(fromNum).add(toNum);
                    edges.get(toNum).add(fromNum);
                }
            }
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] visit = new int[tMap.size()];
        for (int i=0;i<tMap.size();i++) visit[i] = tMap.size();
        visit[0] = 0;
        deque.addLast(0);
        while (!deque.isEmpty()) {
            int now = deque.removeFirst();
            ArrayList<Integer> nowEdges = edges.get(now);
            for (int i = 0; i < nowEdges.size(); i++) {
                Integer to = edges.get(now).get(i);
                if (visit[to] > visit[now] + 1) {
                    visit[to] = visit[now] + 1;
                    deque.addLast(to);
                }
            }
        }
        return visit[1] == tMap.size() ? -1 : visit[1];
    }
}