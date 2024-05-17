package leetcode.normal.j826;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/most-profit-assigning-work/description/">826. 安排工作以达到最大收益</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length, m = worker.length;
        Integer[] pos = new Integer[n];
        for (int i = 0; i < n; i++) pos[i] = i;
        Arrays.sort(pos, Comparator.comparingInt(x -> difficulty[x]));
        int mx = 0;
        Arrays.sort(worker);
        int idxDiff = 0, idxWorker = 0, ans = 0;
        while (idxWorker < m) {
            while (idxDiff < n && difficulty[pos[idxDiff]] <= worker[idxWorker]) {
                mx = Math.max(mx, profit[pos[idxDiff]]);
                ++idxDiff;
            }
            if (idxDiff > 0) {
                ans += mx;
            }
            ++idxWorker;
        }
        return ans;
    }
}