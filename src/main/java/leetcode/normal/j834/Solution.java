package leetcode.normal.j834;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/sum-of-distances-in-tree/">834. 树中距离之和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    List<Integer>[] edges;
    int[] sonNum, ans;

    public int[] sumOfDistancesInTree(int n, int[][] _edges) {
        edges = new List[n];
        ans = new int[n];
        sonNum = new int[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int[] e : _edges) {
            edges[e[0]].add(e[1]);
            edges[e[1]].add(e[0]);
        }
        calcSonNum(0, 0);
        for (int i = 1; i < n; i++) {
            ans[0] += sonNum[i];
        }
        dfs(0, 0);
        return ans;
    }

    int calcSonNum(int parent, int current) {
        if (sonNum[current] > 0) return sonNum[current];
        sonNum[current] = 1;
        for (Integer to : edges[current]) {
            if (to == parent) continue;
            sonNum[current] += calcSonNum(current, to);
        }
        return sonNum[current];
    }

    void dfs(int parent, int current) {
        for (Integer to : edges[current]) {
            if (to == parent) continue;
            // 当前的答案为：ans[parent] + 除了 current 为子树的其他节点数(不包括current) - to 的子节点数(不包括to)
            ans[to] = ans[current] + (sonNum[0] - sonNum[to] - 1) - (sonNum[to] - 1);
            dfs(current, to);
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        Solution solution = new Solution();
        System.out.println(Arrays.asList(solution.sumOfDistancesInTree(6, edges)));
    }
}