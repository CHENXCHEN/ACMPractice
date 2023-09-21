package leetcode.normal.j2603;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/collect-coins-in-a-tree/description/">2603. 收集树中金币</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int collectTheCoins(int[] coins, int[][] _edges) {
        int n = coins.length;
        ArrayList<Integer>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        int[] du = new int[n];
        for (int[] edge : _edges) {
            int u = edge[0], v = edge[1];
            edges[u].add(v);
            edges[v].add(u);
            ++du[u];
            ++du[v];
        }
        // 删除所有没有金币的叶子节点
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int tot = n;
        for (int i = 0; i < n; i++) {
            if (du[i] == 1 && coins[i] == 0) {
                deque.add(i);
            }
        }
        while (!deque.isEmpty()) {
            Integer now = deque.poll();
            --tot;
            du[now]--;
            for (Integer next : edges[now]) {
                du[next]--;
                if (du[next] == 1 && coins[next] == 0) {
                    deque.add(next);
                }
            }
        }
        // 删除两次叶子结点，因为在一点可以收集范围为 2 以内的节点的金币
        for (int k = 0; k < 2; k++) {
            deque = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (du[i] == 1) {
                    deque.add(i);
                }
            }
            while (!deque.isEmpty()) {
                Integer now = deque.poll();
                --tot;
                du[now]--;
                for (Integer next : edges[now]) {
                    du[next]--;
                }
            }
        }
        // 最后可以走的边数可以通过剩余点的数量计算出来
        return tot == 0 ? 0 : (tot - 1) << 1;
    }
}