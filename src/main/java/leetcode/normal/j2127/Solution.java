package leetcode.normal.j2127;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-employees-to-be-invited-to-a-meeting/description/">2127. 参加会议的最多员工数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {

    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        ArrayList<Integer>[] edges = new ArrayList[n];
        int[] du = new int[n];
        int[] dis = new int[n];
        Arrays.fill(dis, 1);
        int ans, tot;
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges[i].add(favorite[i]);
            ++du[favorite[i]];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (du[i] == 0) pq.add(i);
        }
        while (!pq.isEmpty()) {
            Integer now = pq.poll();
            for (Integer next : edges[now]) {
                dis[next] = Math.max(dis[next], dis[now] + 1);
                --du[next];
                if (du[next] == 0) pq.add(next);
            }
        }
        ans = 0;
        tot = 0;
        for (int i = 0; i < n; i++) {
            if (du[i] > 0) {
                int j = favorite[i];
                if (favorite[j] == i) {
                    tot += dis[i] + dis[j];
                    du[i] = du[j] = 0;
                } else {
                    int cnt = 0;
                    while (du[j] > 0) {
                        du[j] = 0;
                        ++cnt;
                        j = favorite[j];
                    }
                    System.out.println();
                    ans = Math.max(ans, cnt);
                }
            }
        }
        return Math.max(ans, tot);
    }
}