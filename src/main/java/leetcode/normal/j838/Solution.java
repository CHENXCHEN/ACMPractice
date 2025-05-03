package leetcode.normal.j838;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/push-dominoes/description/">838. 推多米诺</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        StringBuffer sb = new StringBuffer(dominoes);
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == 'L') {
                deque.push(new int[]{i, -1});
                dis[i] = 0;
            } else if (dominoes.charAt(i) == 'R') {
                deque.push(new int[]{i, 1});
                dis[i] = 0;
            }
        }
        while (!deque.isEmpty()) {
            int[] cur = deque.pop();
            int idx = cur[0], dir = cur[1];
            int next = idx + dir;
            if (next >= 0 && next < n && dominoes.charAt(next) == '.') {
                if (dis[next] == -1) {
                    dis[next] = dis[idx] + 1;
                    sb.setCharAt(next, sb.charAt(idx));
                    deque.add(new int[]{next, dir});
                } else if (sb.charAt(next) != sb.charAt(idx) && dis[next] == dis[idx] + 1) {
                    sb.setCharAt(next, '.');
                }
            }
        }
        return sb.toString();
    }
}