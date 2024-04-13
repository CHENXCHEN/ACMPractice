package leetcode.normal.j2924;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-champion-ii/description/">2924. 找到冠军 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] ru = new int[n];
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            ru[v]++;
        }
        int cnt = 0, ans = -1;
        for (int i = 0; i < n; i++) {
            if (ru[i] == 0) {
                ans = i;
                ++cnt;
            }
        }
        return cnt == 1 ? ans : -1;
    }
}