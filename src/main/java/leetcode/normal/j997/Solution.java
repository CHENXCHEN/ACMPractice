package leetcode.normal.j997;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-town-judge/description/">997. 找到小镇的法官</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] ru = new int[n + 1], chu = new int[n + 1];
        for (int[] e : trust) {
            chu[e[0]]++;
            ru[e[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (ru[i] == n - 1 && chu[i] == 0) return i;
        }
        return -1;
    }
}