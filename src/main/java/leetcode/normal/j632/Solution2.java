package leetcode.normal.j632;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/smallest-range-covering-elements-from-k-lists/description/">632. 最小区间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int[] smallestRange(List<List<Integer>> nums) {
        // 优先队列，维护每个数组的指针，使用优先队列找出这几个指针的最小值，每次递增最小值的指针
        int[] ans = new int[2], next = new int[nums.size()];
        int lastLen = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> nums.get(x).get(next[x]) - nums.get(y).get(next[y]));
        for (int i = 0; i < nums.size(); i++) {
            pq.add(i);
            mx = Math.max(mx, nums.get(i).get(0));
        }
        while (true) {
            Integer minIdx = pq.poll();
            int curLen = mx - nums.get(minIdx).get(next[minIdx]);
            if (curLen < lastLen) {
                lastLen = curLen;
                ans[0] = nums.get(minIdx).get(next[minIdx]);
                ans[1] = mx;
            }
            next[minIdx]++;
            if (next[minIdx] == nums.get(minIdx).size()) break;
            pq.add(minIdx);
            mx = Math.max(mx, nums.get(minIdx).get(next[minIdx]));
        }
        return ans;
    }
}