package leetcode.normal.j2244;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-rounds-to-complete-all-tasks/description/">2244. 完成所有任务需要的最少轮数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int last = -1, cnt = 0;
        int ans = 0;
        for (int task : tasks) {
            if (task != last) {
                if (cnt > 0) {
                    if (cnt == 1) return -1;
                    // 2 -> 1, 3 -> 1, 4 -> 2, 5 -> 2, 6 -> 2, 7 -> 3, 8 -> 3, 9 -> 3, 10 -> 4, 11 -> 4, 12 -> 4
                    ans += (cnt + 2) / 3;
                }
                cnt = 0;
                last = task;
            }
            ++cnt;
        }
        if (cnt == 1) return -1;
        else ans += (cnt + 2) / 3;
        return ans;
    }
}