package leetcode.normal.j1061;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/lexicographically-smallest-equivalent-string/description/">1061. 按字典序排列最小的等效字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        ArrayList<Integer>[] edges = new ArrayList[26];
        for (int i = 0; i < 26; i++) edges[i] = new ArrayList<>();
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            edges[c2 - 'a'].add(c1 - 'a');
            edges[c1 - 'a'].add(c2 - 'a');
        }
        int[] mp = new int[26];
        Arrays.fill(mp, -1);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < 26; i++) {
            if (mp[i] == -1) {
                mp[i] = i;
                deque.add(i);
                while (!deque.isEmpty()) {
                    Integer u = deque.pollFirst();
                    for (Integer v : edges[u]) {
                        if (mp[v] == -1) {
                            mp[v] = i;
                            deque.add(v);
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            char c = baseStr.charAt(i);
            sb.append((char) ('a' + mp[c - 'a']));
        }
        return sb.toString();
    }
}