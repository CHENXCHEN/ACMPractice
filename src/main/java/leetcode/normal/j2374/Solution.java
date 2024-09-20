package leetcode.normal.j2374;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/node-with-highest-edge-score/description/">2374. 边积分最高的节点</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] vv = new long[n];
        for (int i = 0; i < n; i++) {
            vv[edges[i]] += i;
        }
        int mx = 0;
        for (int i = 1; i < n; i++) {
            if (vv[mx] < vv[i]) mx = i;
        }
        return mx;
    }
}