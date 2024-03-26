package leetcode.normal.j2642;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/design-graph-with-shortest-path-calculator/description/">2642. 设计可以求最短路径的图类</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Graph {
    ArrayList<int[]>[] edges;
    int n;

    public Graph(int n, int[][] _edges) {
        this.n = n;
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int[] edge : _edges) {
            addEdge(edge);
        }
    }

    public void addEdge(int[] edge) {
        int u = edge[0], v = edge[1], w = edge[2];
        edges[u].add(new int[]{v, w});
    }

    public int shortestPath(int node1, int node2) {
        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        dis[node1] = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(node1);
        while (!deque.isEmpty()) {
            Integer u = deque.poll();
            for (int[] next : edges[u]) {
                int v = next[0], w = next[1];
                if (dis[v] == -1 || dis[u] + w < dis[v]) {
                    dis[v] = dis[u] + w;
                    deque.add(v);
                }
            }
        }
        return dis[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */