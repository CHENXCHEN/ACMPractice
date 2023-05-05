package leetcode.normal.j2432;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/the-employee-that-worked-on-the-longest-task/">2432. 处理用时最长的那个任务的员工</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int lastTime = 0, maxCost = 0, maxId = 0;
        for (int[] log : logs) {
            int cost = log[1] - lastTime;
            if (cost > maxCost) {
                maxCost = cost;
                maxId = log[0];
            } else if (cost == maxCost && log[0] < maxId) {
                maxId = log[0];
            }
            lastTime = log[1];
        }
        return maxId;
    }
}