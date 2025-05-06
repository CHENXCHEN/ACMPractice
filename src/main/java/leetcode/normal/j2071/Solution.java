package leetcode.normal.j2071;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-number-of-tasks-you-can-assign/description/">2071. 你可以安排的最多任务数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] tasks, workers;
    int pills, strength;

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        this.workers = workers;
        this.tasks = tasks;
        this.pills = pills;
        this.strength = strength;
        int n = tasks.length, m = workers.length;
        // 具备单调性，若 k 个任务可以完成，那么 k - 1 个任务也一定可以完成，因此每次只需要判断可行性即可
        int left = 1, right = Math.min(n, m), ans = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (check(mid)) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }

    boolean check(int mid) {
        // 因为需要判断 mid 个任务是否可以完成，取最大的 mid 个 workers 和最小的 mid 个 tasks，可以使得使用药丸次数最小
        int p = pills;
        TreeMap<Integer, Integer> ws = new TreeMap<>();
        for (int i = workers.length - mid; i < workers.length; i++) {
            ws.compute(workers[i], (key, val) -> val == null ? 1 : val + 1);
        }
        for (int i = mid - 1; i >= 0; i--) {
            Integer key = ws.lastKey();
            if (key >= tasks[i]) {
                // 对于当前的任务，如果最大的工人大于它，那么可以不使用药丸
                ws.compute(key, (k, v) -> v == 1 ? null : v - 1);
            } else {
                if (p == 0) return false;
                // 对于当前任务，需要找到最小的使用药丸可以完成的那个工人
                key = ws.ceilingKey(tasks[i] - strength);
                if (key == null) return false;
                ws.compute(key, (k, v) -> v == 1 ? null : v - 1);
                --p;
            }
        }
        return true;
    }
}