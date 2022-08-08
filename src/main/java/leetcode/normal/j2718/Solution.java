package leetcode.normal.j2718;

import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/get-kth-magic-number-lcci/">面试题 17.09. 第 k 个数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int getKthMagicNumber(int k) {
        int[] r = {3, 5, 7};
        TreeSet<Long> vis = new TreeSet<>();
        vis.add(1L);
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        int cnt = 1;
        while (cnt < k) {
            ++cnt;
            Long now = queue.poll();
            for (int dx : r) {
                if (!vis.contains(now * dx)) {
                    vis.add(now * dx);
                    queue.add(now * dx);
                }
            }
        }
        return queue.poll().intValue();
    }
}