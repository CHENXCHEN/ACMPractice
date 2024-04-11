package leetcode.normal.j1766;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/tree-of-coprimes/description/">1766. 互质树</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    ArrayList<Integer>[] edges;
    int[] lastNode, ans, nums, nodePos;
    long[] mark;
    int tot;

    public int[] getCoprimes(int[] nums, int[][] _edges) {
        int n = nums.length;
        mark = new long[51];
        lastNode = new int[51];
        ans = new int[n];
        nodePos = new int[n];
        tot = 0;
        this.nums = nums;
        Arrays.fill(lastNode, -1);
        for (int i = 1; i <= 50; i++) {
            for (int j = 1; j <= i; j++) {
                if (gcd(i, j) == 1) {
//                    System.out.println("i: " + i + " j: " + j);
                    mark[i] |= 1L << j;
                    mark[j] |= 1L << i;
                }
            }
        }
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] e : _edges) {
            int u = e[0], v = e[1];
            edges[u].add(v);
            edges[v].add(u);
        }
        solve(0, 0);
        return ans;
    }

    void solve(int cur, int parent) {
        nodePos[cur] = ++tot;
        int curNum = nums[cur];
        long curMark = mark[curNum];
        int res = -1;
        for (int i = 1; i <= 50; i++) {
            if ((curMark >> i & 1) == 1 && lastNode[i] != -1) {
                int preNode = lastNode[i];
                if (res == -1) res = preNode;
                else if (nodePos[preNode] > nodePos[res]) res = preNode;
            }
        }
        ans[cur] = res;
        int preNode = lastNode[curNum];
        lastNode[curNum] = cur;
        for (Integer v : edges[cur]) {
            if (v != parent) solve(v, cur);
        }
        lastNode[curNum] = preNode;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}