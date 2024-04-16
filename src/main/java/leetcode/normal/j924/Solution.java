package leetcode.normal.j924;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimize-malware-spread/description/">924. 尽量减少恶意软件的传播</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        int[] idMap = new int[n], cnt = new int[n];
        int tot = -1;
        Arrays.fill(idMap, -1);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (graph[i][j] == 1) {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (idMap[i] == -1) {
                idMap[i] = ++tot;
                deque.push(i);
                int size = 0;
                while (!deque.isEmpty()) {
                    Integer cur = deque.pop();
                    ++size;
                    for (Integer to : edges[cur]) {
                        if (idMap[to] == -1) {
                            idMap[to] = tot;
                            deque.push(to);
                        }
                    }
                }
                cnt[tot] = size;
            }
        }
        int[] initCnt = new int[n];
        for (int v : initial) {
            ++initCnt[idMap[v]];
        }
        int ans = n + 1, lastRemove = 0;
        for (int u : initial) {
            int remove = initCnt[idMap[u]] == 1 ? cnt[idMap[u]] : 0;
            if (remove > lastRemove || (remove == lastRemove && u < ans)) {
                ans = u;
                lastRemove = remove;
            }
        }
        return ans;
    }
}