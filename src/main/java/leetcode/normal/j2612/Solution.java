package leetcode.normal.j2612;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-reverse-operations/description/">2612. 最少翻转操作数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        Set<Integer> ban = new HashSet<>();
        for (int banIdx : banned) ban.add(banIdx);
        TreeSet<Integer>[] set = new TreeSet[2];
        set[0] = new TreeSet<>();
        set[1] = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (i != p && !ban.contains(i)) {
                set[i % 2].add(i);
            }
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(p);
        ans[p] = 0;
        while (!queue.isEmpty()) {
            int i = queue.poll();
            // 当前位置翻转可以到达的位置范围在 [i-k+1,i+k-1]
            // 但是需要约束数组的范围，即子数组位于最左与最右时
            // 当子数组位于最左时，l=0,r=k-1,i'=k-i-1
            // 当子数组位于最右时候，l=n-k,r=n-1, i'=n-1-n+k-i=2n-k-i-1
            int minLeft = Math.max(i - k + 1, k - i - 1);
            int maxRight = Math.min(i + k - 1, n * 2 - k - i - 1);
            TreeSet<Integer> ss = set[maxRight % 2];
            Integer it = set[maxRight % 2].ceiling(minLeft);
            while (it != null && it <= maxRight) {
                ans[it] = ans[i] + 1;
                queue.add(it);
                ss.remove(it);
                it = ss.ceiling(minLeft);
            }
        }
        return ans;
    }
}