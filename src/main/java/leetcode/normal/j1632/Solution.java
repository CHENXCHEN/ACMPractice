package leetcode.normal.j1632;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/rank-transform-of-a-matrix/">1632. 矩阵转换后的秩</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int rows, cols;
    int[] parent;

    int find(int x) {
        if (x != parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int x, int y) {
        if (x == y) return;
        int faX = find(x), faY = find(y);
        if (faX > faY) parent[faX] = faY;
        else parent[faY] = faX;
    }

    void collectNodes(Set<Integer> ss) {
        if (ss.isEmpty()) return;
        int first = ss.stream().findFirst().get();
        for (Integer to : ss) {
            union(first, to);
        }
    }

    void merge(TreeMap<Integer, Set<Integer>> ori, TreeMap<Integer, Set<Integer>> need) {
        for (Map.Entry<Integer, Set<Integer>> entry : need.entrySet()) {
            ori.computeIfAbsent(entry.getKey(), k -> new HashSet<>())
                    .addAll(entry.getValue());
        }
    }

    public int[][] matrixRankTransform(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        parent = new int[rows * cols];
        for (int i = 0; i < parent.length; i++) parent[i] = i;
        int[][] ans = new int[rows][cols];
        Map<Integer, ArrayList<Integer>> edges = new HashMap<>();
        int[] ru = new int[rows * cols];
        TreeMap<Integer, Set<Integer>> tmp = new TreeMap<>();
        // 先合并节点
        TreeMap<Integer, Set<Integer>>[] rowTmp = new TreeMap[rows], colTmp = new TreeMap[cols];
        for (int i = 0; i < rows; i++) {
            rowTmp[i] = new TreeMap<>();
            for (int j = 0; j < cols; j++) {
                rowTmp[i].computeIfAbsent(matrix[i][j], k -> new HashSet<>())
                        .add(i * cols + j);
                if (colTmp[j] == null) colTmp[j] = new TreeMap<>();
                colTmp[j].computeIfAbsent(matrix[i][j], k -> new HashSet<>())
                        .add(i * cols + j);
            }
        }
        for (int i = 0; i < rows; i++)
            for (Map.Entry<Integer, Set<Integer>> entry : rowTmp[i].entrySet())
                collectNodes(entry.getValue());
        for (int j = 0; j < cols; j++)
            for (Map.Entry<Integer, Set<Integer>> entry : colTmp[j].entrySet())
                collectNodes(entry.getValue());

        // 先计算行的依赖顺序
        for (int i = 0; i < rows; i++) {
            tmp = rowTmp[i];
            Integer last = tmp.firstKey(), cur = tmp.higherKey(last);
            while (cur != null) {
                Integer start = tmp.get(last).stream().findFirst().get();
                Integer end = tmp.get(cur).stream().findFirst().get();
                int from = find(start), to = find(end);
                addEdge(edges, from, to);
                ++ru[to];
                last = cur;
                cur = tmp.higherKey(last);
            }
        }
        // 再计算列的依赖顺序
        for (int i = 0; i < cols; i++) {
            tmp = colTmp[i];
            Integer last = tmp.firstKey(), cur = tmp.higherKey(last);
            while (cur != null) {
                Integer start = tmp.get(last).stream().findFirst().get();
                Integer end = tmp.get(cur).stream().findFirst().get();
                int from = find(start), to = find(end);
                addEdge(edges, from, to);
                ++ru[to];
                last = cur;
                cur = tmp.higherKey(last);
            }
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] vis = new int[rows * cols];
        for (int i = 0; i < ru.length; i++) {
            if (ru[i] == 0) {
                deque.add(i);
                vis[i] = 1;
            }
        }
        while (!deque.isEmpty()) {
            Integer cur = deque.poll();
            for (Integer to : edges.getOrDefault(cur, new ArrayList<>())) {
                --ru[to];
                if (ru[to] == 0 || (ru[to] < 0 && vis[to] < vis[cur] + 1)) {
                    vis[to] = Math.max(vis[to], vis[cur] + 1);
                    deque.add(to);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int pos = i * cols + j;
                ans[i][j] = vis[find(pos)];
            }
        }
        return ans;
    }

    void addEdge(Map<Integer, ArrayList<Integer>> edges, int from, int to) {
        ArrayList<Integer> e = edges.get(from);
        if (e == null) e = new ArrayList<>();
        e.add(to);
        if (e.size() == 1) edges.put(from, e);
//        int x = from / cols, y = from % cols;
//        int x1 = to / cols, y1 = to % cols;
//        System.out.printf("(%d,%d) -> (%d,%d)%n", x, y, x1, y1);
    }
}