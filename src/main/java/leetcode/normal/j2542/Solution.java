package leetcode.normal.j2542;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/Jf1JuT/
 * 剑指 Offer II 114. 外星文字典
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String alienOrder(String[] words) {
        ArrayList<TreeSet<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < 26; i++) edges.add(new TreeSet<>());
        int[] ru = new int[26], chu = new int[26], vis = new int[26];
        boolean[][] already = new boolean[26][26];
        for (int i = 0; i < words[0].length(); i++) vis[words[0].charAt(i) - 'a'] = 1;
        for (int i = 0; i < words.length - 1; i++) {
            int j = 0;
            while (j < words[i].length() && j < words[i + 1].length() && words[i].charAt(j) == words[i + 1].charAt(j)) {
                int now = words[i].charAt(j) - 'a';
                vis[now] = 1;
                j++;
            }
            if (j == words[i].length() && words[i].length() > words[i + 1].length()) return "";
            else if (j == words[i + 1].length() && j < words[i].length()) return "";
            else if (j < words[i].length() && j < words[i + 1].length()) {
                int from = words[i].charAt(j) - 'a';
                int to = words[i + 1].charAt(j) - 'a';
                if (!already[from][to]) {
                    already[from][to] = true;
                    edges.get(from).add(to);
                    vis[from] = vis[to] = 1;
                    chu[from]++;
                    ru[to]++;
                }
            }
            while (j < words[i + 1].length()) {
                if (j < words[i].length()) {
                    int from = words[i].charAt(j) - 'a';
                    vis[from] = 1;
                }
                int to = words[i + 1].charAt(j) - 'a';
                vis[to] = 1;
                j++;
            }
        }
        if (checkCircle(edges)) return "";
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < 26; i++) {
            if (ru[i] == 0 && vis[i] > 0) deque.add(i);
        }
        while (!deque.isEmpty()) {
            int now = deque.pop();
            sb.append((char) ('a' + now));
            TreeSet<Integer> nextEdges = edges.get(now);
            for (Integer nextEdge : nextEdges) {
                --ru[nextEdge];
                if (ru[nextEdge] == 0) {
                    deque.add(nextEdge);
                }
            }
        }
        return sb.toString();
    }

    boolean checkCircle(ArrayList<TreeSet<Integer>> edges) {
        int[] has = new int[26];
        int tot = 1;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < 26; i++) {
            if (edges.get(i).size() > 0 && has[i] == 0) {
                deque.add(i);
                while (!deque.isEmpty()) {
                    Integer now = deque.pop();
                    has[now] = tot;
                    TreeSet<Integer> nextEdges = edges.get(now);
                    for (Integer nextEdge : nextEdges) {
                        if (nextEdge.equals(now)) continue;
                        if (has[nextEdge] == tot) return true;
                        if (has[nextEdge] == 0)
                            deque.add(nextEdge);
                    }
                }
                tot++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String[] strs = {"wrt", "wrf", "er", "ett", "rftt"};
//        String[] strs = {"zd", "zabc"};
        String[] strs = {"ac", "ab", "zc", "zb"};
        System.out.println(solution.alienOrder(strs));
    }
}