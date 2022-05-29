package leetcode.dweek.j79.j6085;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/maximum-total-importance-of-roads/
 * 6085. 道路的最大总重要性
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] has = new int[n];
        for (int[] road : roads) {
            has[road[0]]++;
            has[road[1]]++;
        }
        Arrays.sort(has);
        long ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans += has[i] * (i + 1L);
        }
        return ans;
    }
}